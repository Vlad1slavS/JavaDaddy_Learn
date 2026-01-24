package io.github.vladislav.Lambda_Stream.topic1_LambdaExpressions.task2_StringModifier;

/**
 * Задача 2 "Функциональный интерфейс StringModifier"
 * @author Владислав Степанов
 */
public class StringModifierDemo {
    public static void main(String[] args) {
        StringModifier stringModifier = (s) -> s.toUpperCase().concat("!");
        System.out.println(stringModifier.modify("hello"));
    }
}
