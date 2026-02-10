package io.github.vladislav.TODO_App.repository.Impl;

import io.github.vladislav.TODO_App.model.enums.TaskStatus;
import io.github.vladislav.TODO_App.model.Task;
import io.github.vladislav.TODO_App.repository.ITaskRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryTaskRepository implements ITaskRepository {

    private final Map<UUID, Task> taskMap = new HashMap<>();

    public List<Task> getAllTasks() {
        return this.taskMap.values().stream().toList();
    }

    public Task saveOrUpdateTask(Task task) {
        taskMap.put(task.getId(), task);
        return task;
    }

    public Optional<Task> getTaskById(UUID id) {
        return Optional.ofNullable(taskMap.get(id));
    }

    public List<Task> getTasksWithStatusFilter(TaskStatus status) {
        return this.taskMap.values().stream()
                .filter(t -> t.getStatus() == status).toList();
    }

    public boolean deleteTask(UUID taskId) {
        return taskMap.remove(taskId) != null;
    }

    public void clearRepository() {
        taskMap.clear();
    }

    public boolean existsById(UUID id) {
        return taskMap.containsKey(id);
    }

}
