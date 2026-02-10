package Service;

import io.github.vladislav.TODO_App.model.Task;
import io.github.vladislav.TODO_App.model.enums.TaskStatus;
import io.github.vladislav.TODO_App.repository.Impl.InMemoryTaskRepository;
import io.github.vladislav.TODO_App.service.TaskService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private static InMemoryTaskRepository inMemoryTaskRepository;

    @AfterAll
    public static void tearDown() {
        inMemoryTaskRepository.clearRepository();
    }
    
    @Test
    public void getAllTasks_validTasks_sizeReturnedList() {
        Task task = Task.builder()
                .title("Sample Task")
                .description("This is a sample task")
                .dueDate(null)
                .status(null)
                .build();

        Task task2 = Task.builder()
                .title("Sample Task 2")
                .description("This is a sample task 2")
                .dueDate(null)
                .status(null)
                .build();

        when(inMemoryTaskRepository.getAllTasks()).thenReturn(List.of(task, task2));

        List<Task> tasks = taskService.getAllTasks();
        assertEquals(2, tasks.size());
    }

    @Test
    public void getAllTasks_validTasks_emptyList() {
        when(inMemoryTaskRepository.getAllTasks()).thenReturn(List.of());

        List<Task> tasks = taskService.getAllTasks();
        assertEquals(0, tasks.size());
    }

    @Test
    public void createTask_validTask_taskCreated() {

        when(inMemoryTaskRepository.saveOrUpdateTask(any(Task.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Task createdTask = taskService.createTask("New Task", "This is a new task", "2026-12-31");

        assertEquals("New Task", createdTask.getTitle());
        assertEquals("This is a new task", createdTask.getDescription());
        assertEquals(LocalDate.parse("2026-12-31"), createdTask.getDueDate());

    }

    @Test
    public void createTask_invalidDate_exceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.createTask("New Task", "This is a new task", "2025-12-31");
        });
        verify(inMemoryTaskRepository, never()).saveOrUpdateTask(any());
    }

    @Test
    public void createTask_emptyTitle_exceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.createTask("", "This is a new task", "2026-12-31");
        });
        verify(inMemoryTaskRepository, never()).saveOrUpdateTask(any());
    }

    @Test
    public void createTask_longDescription_exceptionThrown() {
        String longDescription = "long".repeat(126);
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.createTask("Test", longDescription, "2026-12-31");
        });
        verify(inMemoryTaskRepository, never()).saveOrUpdateTask(any());
    }

    @Test
    public void updateTaskStatus_validStatus_taskUpdated() {
        Task existingTask = Task.builder()
                .title("Existing Task")
                .description("This is an existing task")
                .dueDate(null)
                .status(null)
                .build();

        when(inMemoryTaskRepository.getTaskById(any())).thenReturn(Optional.of(existingTask));
        when(inMemoryTaskRepository.saveOrUpdateTask(any(Task.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Task updatedTask = taskService.updateTaskStatus(existingTask.getId(), TaskStatus.DONE);

        assertEquals(TaskStatus.DONE, updatedTask.getStatus());
    }

    @Test
    public void updateTaskStatus_nonExistentTask_exceptionThrown() {
        when(inMemoryTaskRepository.getTaskById(any())).thenReturn(Optional.empty());

        assertThrows(java.util.NoSuchElementException.class, () -> {
            taskService.updateTaskStatus(java.util.UUID.randomUUID(), TaskStatus.DONE);
        });
        verify(inMemoryTaskRepository, never()).saveOrUpdateTask(any());
    }

    @Test
    public void updateTask_invalidDate_exceptionThrown() {

        UUID taskId = UUID.randomUUID();
        Task existingTask = Task.builder()
                .title("Existing Task")
                .description("This is an existing task")
                .dueDate(null)
                .status(null)
                .build();

        when(inMemoryTaskRepository.getTaskById(any())).thenReturn(Optional.of(existingTask));

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTask(taskId, "Updated Task", "Updated description", "2023-01-01");
        });
        verify(inMemoryTaskRepository, never()).saveOrUpdateTask(any());
    }

    @Test
    public void updateTask_emptyTitle_exceptionThrown() {
        UUID taskId = UUID.randomUUID();
        Task existingTask = Task.builder()
                .title("Existing Task")
                .description("This is an existing task")
                .dueDate(null)
                .status(null)
                .build();

        when(inMemoryTaskRepository.getTaskById(any())).thenReturn(Optional.of(existingTask));

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTask(taskId, "", "Updated description", "2026-12-31");
        });
        verify(inMemoryTaskRepository, never()).saveOrUpdateTask(any());
    }

    @Test
    public void updateTask_longDescription_exceptionThrown() {
        String description = "long".repeat(126);

        UUID taskId = UUID.randomUUID();

        Task existingTask = Task.builder()
                .title("Existing Task")
                .description("This is an existing task")
                .dueDate(null)
                .status(null)
                .build();

        when(inMemoryTaskRepository.getTaskById(any())).thenReturn(Optional.of(existingTask));

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTask(taskId, "Updated Task", description, "2026-12-31");
        });
        verify(inMemoryTaskRepository, never()).saveOrUpdateTask(any());
    }

    @Test
    public void deleteTask_validTask_taskDeleted() {

        UUID existingTaskUUID = UUID.randomUUID();

        when(inMemoryTaskRepository.deleteTask(any(UUID.class))).thenReturn(true);
        taskService.deleteTask(existingTaskUUID);
    }

    @Test
    public void deleteTask_nonExistentTask_exceptionThrown() {
        UUID nonExistentUUID = UUID.randomUUID();

        when(inMemoryTaskRepository.deleteTask(nonExistentUUID)).thenReturn(false);

        assertThrows(java.util.NoSuchElementException.class, () -> {
            taskService.deleteTask(nonExistentUUID);
        });
    }

    @Test
    public void getTasksWithStatusFilter_invalidStatus_emptyList() {
        when(inMemoryTaskRepository.getTasksWithStatusFilter(TaskStatus.DONE)).thenReturn(List.of());
        List<Task> tasks = taskService.getTasksWithStatusFilter(TaskStatus.DONE);
        assertEquals(0, tasks.size());
    }

    @Test
    public void getTaskById_invalidId_exceptionThrown() {
        UUID nonExistentUUID = UUID.randomUUID();

        when(inMemoryTaskRepository.getTaskById(nonExistentUUID)).thenReturn(Optional.empty());
        assertThrows(java.util.NoSuchElementException.class, () -> {
            taskService.getTaskById(nonExistentUUID);
        });
    }



}
