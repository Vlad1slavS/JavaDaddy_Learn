package io.github.vladislav.TODO_App.validator;


import io.github.vladislav.TODO_App.model.Task;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Утилитарный класс для валидации задач
 * @author Владислав Степанов
 */
public class TaskValidator {

    private static final Integer TITLE_MAX_LENGTH = 100;
    private static final Integer DESCRIPTION_MAX_LENGTH = 500;

    /**
     * Валидация даты
     * @param date - дата в формате гггг-мм-дд
     * @throws IllegalArgumentException - если дата некорректна
     */
    public static void validateDate(String date) {
        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException("Дата не может быть пустой.");
        }
        try {
            LocalDate localDate = LocalDate.parse(date);
            if (localDate.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Дата не может быть в прошлом.");
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Неверный формат даты. Используйте гггг-мм-дд");
        }
    }

    /**
     * Валидация основных полей задачи
     * @param task - задача для валидации
     * @throws IllegalArgumentException - если дата некорректна
     */
    public static void validateTask(Task task) {
        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Название задачи не может быть пустым");
        }
        if (task.getTitle().length() > TITLE_MAX_LENGTH) {
            throw new IllegalArgumentException("Название задачи не может превышать " + TITLE_MAX_LENGTH + " символов");
        }
        if (task.getDescription().length() > DESCRIPTION_MAX_LENGTH) {
            throw new IllegalArgumentException("Описание задачи не может превышать " + DESCRIPTION_MAX_LENGTH + " символов");
        }
    }

}
