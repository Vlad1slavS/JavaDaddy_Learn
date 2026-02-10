package io.github.vladislav.TODO_App.repository;

import io.github.vladislav.TODO_App.model.enums.TaskStatus;
import io.github.vladislav.TODO_App.model.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ITaskRepository {

    List<Task> getAllTasks();

    Optional<Task> getTaskById(UUID id);

    Task saveOrUpdateTask(Task task);

    List<Task> getTasksWithStatusFilter(TaskStatus status);

    boolean deleteTask(UUID taskId);

    void clearRepository();

    boolean existsById(UUID id);

}
