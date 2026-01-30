package io.github.vladislav.Testing.topic1_Junit;

/**
 * Решение задачи для теста 7: Проверка на високосный год
 * @author Владислав Степанов
 */
public class LeapYearChecker {
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }
}