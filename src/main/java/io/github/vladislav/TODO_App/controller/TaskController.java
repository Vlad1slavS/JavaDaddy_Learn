package io.github.vladislav.TODO_App.controller;

import io.github.vladislav.TODO_App.model.enums.SortingOptions;
import io.github.vladislav.TODO_App.model.enums.TaskStatus;
import io.github.vladislav.TODO_App.model.Task;
import io.github.vladislav.TODO_App.service.TaskService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Контроллер для управления задачами
 * @author Владислав Степанов
 * @version 1.0
 */
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    public Task createTask(String title, String description, String deadline) throws IllegalArgumentException {
        return taskService.createTask(title, description, deadline);
    }

    public Task updateTaskStatus(UUID taskId, TaskStatus newStatus) throws NoSuchElementException {
        return taskService.updateTaskStatus(taskId, newStatus);
    }

    public void deleteTask(UUID taskId) throws NoSuchElementException {
        taskService.deleteTask(taskId);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskService.getTasksWithStatusFilter(status);
    }

    public Task updateTask(UUID id, String newTitle, String newDescription, String newDeadline) throws IllegalArgumentException, NoSuchElementException {
        return taskService.updateTask(id, newTitle, newDescription, newDeadline);
    }

    public List<Task> getSortedTasks(SortingOptions sortBy) {
        return taskService.getSortedTasks(sortBy);
    }

    public boolean existsTaskById(UUID id) {
        return taskService.existsById(id);
    }

}
