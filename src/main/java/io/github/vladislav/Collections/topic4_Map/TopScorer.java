package io.github.vladislav.Collections.topic4_Map;

import java.util.HashMap;

/**
 * Задача 3 "Максимальное значение в HashMap"
 * @author Владислав Степанов
 */
public class TopScorer {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Ваня", 85);
        map.put("Петя", 92);
        map.put("Маша", 78);
        map.put("Катя", 95);
        map.put("Саша", 100);
        map.put("Слава", 10);

        String topName = null;
        int maxScore = Integer.MIN_VALUE;
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                topName = entry.getKey();
            }
        }

        System.out.printf("%s: %d", topName, maxScore);

    }
}
