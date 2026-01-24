package io.github.vladislav.Lambda_Stream.topic1_LambdaExpressions;

import java.util.Arrays;
import java.util.List;

public class LambdaArraySortDemo {
    public static void main(String[] args) {
        List<String> arr = Arrays.asList("Java", "Lambda", "Stream", "API");

        arr.sort((s1, s2) -> s1.length() - s2.length());

        System.out.println(arr);
    }
}
