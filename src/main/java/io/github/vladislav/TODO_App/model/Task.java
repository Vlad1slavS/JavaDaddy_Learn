package io.github.vladislav.TODO_App.model;

import io.github.vladislav.TODO_App.model.enums.TaskStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Task {
    private final UUID id;
    private final String title;
    private final String description;
    private final LocalDate dueDate;
    private final TaskStatus status;

    @Builder
    private Task(String title, String description, LocalDate dueDate, TaskStatus status) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    private Task(UUID id, String title, String description, LocalDate deadline, TaskStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = deadline;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task {" +
                "id: " + id +
                ", название: '" + title + '\'' +
                ", описание: '" + description + '\'' +
                ", дедлайн: " + dueDate +
                ", статус: " + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Task withStatus(TaskStatus newStatus) {
        return new Task(this.id, this.title, this.description, this.dueDate, newStatus);
    }

    public Task withUpdatedInfo(String newTitle, String newDescription, LocalDate newDueDate) {
        return new Task(this.id, newTitle, newDescription, newDueDate, this.status);
    }

}