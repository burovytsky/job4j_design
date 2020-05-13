package ru.job4j.examination;

import java.util.*;

public class Contact {
    public static Map<String, Set<String>> grouping(List<String> initialDate) {
        Map<String, Set<String>> result = new HashMap<>();
        Map<String, String> tempMap = new HashMap<>();
        int groupNumber = 0;
        for (String element : initialDate) {
            String groupName = null;
            String[] splitString = element.split(";");
            for (String value : splitString) {
                if (tempMap.containsKey(value)) {
                    groupName = tempMap.get(value);
                    break;
                }
            }
            if (groupName != null) {
                result.get(groupName).add(element);
            } else {
                groupName = "group " + (groupNumber++);
                result.put(groupName, new LinkedHashSet<>());
                result.get(groupName).add(element);
            }
            for (String s : splitString) {
                if (s != null && !s.isEmpty() && !tempMap.containsKey(s)) {
                    tempMap.put(s, groupName);
                }
            }
        }
        return result;
    }
}
