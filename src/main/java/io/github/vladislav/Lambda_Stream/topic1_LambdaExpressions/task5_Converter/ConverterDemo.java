package io.github.vladislav.Lambda_Stream.topic1_LambdaExpressions.task5_Converter;

import java.util.Arrays;

/**
 * Задача 5 "Преобразование массива чисел с использованием Converter"
 * @author Владислав Степанов
 */
public class ConverterDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Converter cv = (x) -> x * x;
        System.out.println(Arrays.toString(convertArray(arr, cv)));
    }

    public static int[] convertArray(int[] array, Converter converter){
        for (int i = 0; i < array.length; i++) {
            array[i] = converter.convert(array[i]);
        }
        return array;
    }
}
