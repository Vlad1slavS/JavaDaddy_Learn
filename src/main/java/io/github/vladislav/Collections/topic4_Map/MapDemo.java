package io.github.vladislav.Collections.topic4_Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Задача 5 "Работа с Map (HashMap)"
 * @author Владислав Степанов
 */
public class MapDemo {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Ваня", 85);
        map.put("Петя", 92);
        map.put("Маша", 78);
        map.put("Коля", 10);
        map.put("Катя", 95);
        map.put("Саша", 100);
        map.put("Слава", 15);

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() > 75) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                it.remove();
            }
        }

        System.out.println("Не попали в выборку:" + map);
    }
}
