package io.github.vladislav.Lambda_Stream.topic1_LambdaExpressions.task4_Filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Задача 4 "Фильтрация элементов массива с использованием MyPredicate"
 * @author Владислав Степанов
 */
public class ArrayFilterDemo {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 10, 20, 30, 15, 7);
        MyPredicate<Integer> myPredicate = s -> s > 10;
        System.out.println(filterArray(arr, myPredicate));
    }

    public static <T> List<T> filterArray(List<T> arr, MyPredicate<T> predicate) {
        List<T> res = new ArrayList<>();
        for (T t : arr) {
            if (predicate.test(t)){
                res.add(t);
            }
        }
        return res;
    }
}
