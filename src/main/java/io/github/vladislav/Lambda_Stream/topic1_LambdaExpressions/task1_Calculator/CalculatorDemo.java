package io.github.vladislav.Lambda_Stream.topic1_LambdaExpressions.task1_Calculator;

/**
 * Задача 1 "Реализация функционального интерфейса Calculator"
 * @author Владислав Степанов
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator sum = (a, b) -> a + b;
        System.out.println(sum.operate(10, 20));
    }
}
