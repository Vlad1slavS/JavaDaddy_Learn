package io.github.vladislav.TODO_App;

import io.github.vladislav.TODO_App.controller.TaskController;
import io.github.vladislav.TODO_App.model.enums.SortingOptions;
import io.github.vladislav.TODO_App.model.enums.TaskStatus;
import io.github.vladislav.TODO_App.model.Task;
import io.github.vladislav.TODO_App.repository.Impl.InMemoryTaskRepository;
import io.github.vladislav.TODO_App.service.TaskService;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final InMemoryTaskRepository taskRepository = new InMemoryTaskRepository();
    private static final TaskService taskService = new TaskService(taskRepository);
    private static final TaskController taskController = new TaskController(taskService);

    public static void main(String[] args) {

        while (true) {
            printMenu();
            String input = SCANNER.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException ex ) {
                System.out.println("Пожалуйста, введите корректный номер действия.");
                continue;
            }
            switch (choice) {
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                case 1:
                    System.out.println("Введите название задачи:");
                    String title = SCANNER.nextLine().trim();

                    System.out.println("Введите описание задачи:");
                    String description = SCANNER.nextLine().trim();

                    System.out.println("Введите дедлайн задачи (формат: гггг-мм-дд, например 2026-02-15):");
                    String dateInput = SCANNER.nextLine().trim();

                    try {
                        System.out.println(taskController.createTask(title, description, dateInput));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Введите id задачи для удаления:");

                    try {
                        UUID id = UUID.fromString(SCANNER.nextLine().trim());
                        taskController.deleteTask(id);
                        System.out.println("Успешно удалено");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Неверный формат UUID. Пожалуйста, введите корректный id задачи.");
                    } catch (NoSuchElementException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Введите id задачи для обновления:");
                    UUID updateId;
                    Task taskToUpdate;

                    try {
                        updateId = UUID.fromString(SCANNER.nextLine().trim());
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Неверный формат UUID. Пожалуйста, введите корректный id задачи.");
                        break;
                    }

                    try {
                        taskToUpdate = taskController.getTaskById(updateId);

                        System.out.println("Введите новое название задачи:");
                        String newTitle = SCANNER.nextLine().trim();

                        System.out.println("Введите новое описание задачи:");
                        String newDescription = SCANNER.nextLine().trim();

                        System.out.println("Введите новый дедлайн задачи (формат: гггг-мм-дд, например 2026-02-15):");
                        String newDateInput = SCANNER.nextLine().trim();

                        System.out.println(taskController.updateTask(taskToUpdate, newTitle, newDescription, newDateInput));

                    } catch (IllegalArgumentException | NoSuchElementException ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;

                case 4:
                    System.out.println("Введите id задачи для обновления статуса:");
                    UUID taskId;

                    try {
                        taskId = UUID.fromString(SCANNER.nextLine().trim());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Неверный формат UUID. Пожалуйста, введите корректный id задачи.");
                        break;
                    }

                    System.out.println("Введите новый статус задачи (TODO, IN_PROGRESS, DONE):");

                    try {
                        TaskStatus newStatus = TaskStatus.valueOf(SCANNER.nextLine());
                        System.out.println(taskController.updateTaskStatus(taskId, newStatus));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Неверный статус. Пожалуйста, используйте TODO, IN_PROGRESS или DONE.");
                    } catch (NoSuchElementException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 5:
                    taskController.getAllTasks().forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Введите статус задачи для фильтрации (TODO, IN_PROGRESS, DONE):");
                    String statusInput = SCANNER.nextLine();
                    try {
                        TaskStatus status = TaskStatus.valueOf(statusInput);
                        System.out.println(taskController.getTasksByStatus(status));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Неверный статус. Пожалуйста, используйте TODO, IN_PROGRESS или DONE.");
                    }
                    break;

                case 7:
                    printSortingOptions();
                    String sortChoice = SCANNER.nextLine().trim();
                    switch (sortChoice) {
                        case "1":
                            taskController.getSortedTasks(SortingOptions.DEADLINE_ASC)
                                    .forEach(System.out::println);
                            break;
                        case "2":
                            taskController.getSortedTasks(SortingOptions.DEADLINE_DESC)
                                    .forEach(System.out::println);
                            break;
                        case "3":
                            taskController.getSortedTasks(SortingOptions.STATUS_ASC)
                                    .forEach(System.out::println);
                            break;
                        case "4":
                            taskController.getSortedTasks(SortingOptions.STATUS_DESC)
                                    .forEach(System.out::println);
                            break;
                        default:
                            System.out.println("Неверный выбор. Пожалуйста, попробуйте снова!");
                    }
                    break;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("0. Выход");
        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу");
        System.out.println("3. Обновить задачу (название, описание, срок)");
        System.out.println("4. Обновить статус задачи");
        System.out.println("5. Посмотреть все задачи");
        System.out.println("6. Посмотреть все задачи (с фильтром по статусу)");
        System.out.println("7. Отсортировать задачи");
    }

    private static void printSortingOptions() {
        System.out.println("Как вы хотите отсортировать задачи?");
        System.out.println("1. По сроку выполнения (возрастание)");
        System.out.println("2. По сроку выполнения (убывание)");
        System.out.println("3. По статусу (возрастание)");
        System.out.println("4. По статусу (убывание)");
    }
}
