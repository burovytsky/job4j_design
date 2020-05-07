package ru.job4j.examination;


import java.util.HashMap;
import java.util.Map;


public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < left.length(); i++) {
            int tmp = left.charAt(i);
            map.merge(tmp, 1, Integer::sum);
        }

        for (int i = 0; i < right.length(); i++) {
            int tmp = right.charAt(i);
            if (map.get(tmp) == null) {
                return false;
            }
            map.put(tmp, map.get(tmp) - 1);
            if (map.get(tmp) < 0) {
                return false;
            }
        }
        return true;
    }
}
