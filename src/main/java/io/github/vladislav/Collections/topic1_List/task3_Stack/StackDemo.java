package io.github.vladislav.Collections.topic1_List.task3_Stack;

import java.util.Stack;

/**
 * Задача 1 "Работа с Stack"
 * @author Владислав Степанов
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");

        System.out.println(stack.peek());

        try {
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
        } catch (Exception e) {
            System.out.println(e.getMessage() + " – " + "стек пустой");
        }
    }
}
