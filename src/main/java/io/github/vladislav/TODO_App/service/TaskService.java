package io.github.vladislav.TODO_App.service;

import io.github.vladislav.TODO_App.model.enums.SortingOptions;
import io.github.vladislav.TODO_App.model.enums.TaskStatus;
import io.github.vladislav.TODO_App.model.Task;
import io.github.vladislav.TODO_App.repository.Impl.InMemoryTaskRepository;
import io.github.vladislav.TODO_App.validator.TaskValidator;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Сервис для управления задачами
 * @author Владислав Степанов
 */
public class TaskService {

    private final InMemoryTaskRepository taskRepository;

    public TaskService(InMemoryTaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public Task createTask(String title, String description, String deadline)
            throws IllegalArgumentException {

        TaskValidator.validateDate(deadline);
        LocalDate date = LocalDate.parse(deadline);

        Task newTask = Task.builder()
                .title(title)
                .description(description)
                .dueDate(date)
                .status(TaskStatus.TODO)
                .build();

        TaskValidator.validateTask(newTask);

        return taskRepository.saveOrUpdateTask(newTask);
    }

    public Task updateTaskStatus(UUID taskId, TaskStatus newStatus) {
        Task oldTask = taskRepository.getTaskById(taskId)
                .orElseThrow(() ->
                        new NoSuchElementException("Задача с id " + taskId + " не найдена")
                );

        Task updatedTask = oldTask.withStatus(newStatus);
        return taskRepository.saveOrUpdateTask(updatedTask);
    }

    public Task updateTask(Task taskToUpdate, String newTitle, String newDescription, String newDeadline) {

        TaskValidator.validateDate(newDeadline);
        LocalDate date = LocalDate.parse(newDeadline);

        Task updatedTask = taskToUpdate.withUpdatedInfo(newTitle, newDescription, date);
        TaskValidator.validateTask(updatedTask);

        return taskRepository.saveOrUpdateTask(updatedTask);
    }

    public void deleteTask(UUID taskId) {
        boolean removed = taskRepository.deleteTask(taskId);
        if (!removed) {
            throw new NoSuchElementException("Задача с id " + taskId + " не найдена");
        }
    }

    public List<Task> getTasksWithStatusFilter(TaskStatus status) {
        return taskRepository.getTasksWithStatusFilter(status);
    }

    public Task getTaskById(UUID id) {
        return taskRepository.getTaskById(id).orElseThrow(() ->
                new NoSuchElementException("Задача с id " + id + " не найдена"));
    }

    public List<Task> getSortedTasks(SortingOptions sortBy) {
        List<Task> tasks = taskRepository.getAllTasks();
        return switch (sortBy) {
            case DEADLINE_ASC -> tasks.stream().sorted(Comparator.comparing(Task::getDueDate)).toList();
            case DEADLINE_DESC -> tasks.stream().sorted(Comparator.comparing(Task::getDueDate).reversed()).toList();
            case STATUS_ASC -> tasks.stream().sorted(Comparator.comparing(Task::getStatus)).toList();
            case STATUS_DESC -> tasks.stream().sorted(Comparator.comparing(Task::getStatus).reversed()).toList();
        };
    }




}
