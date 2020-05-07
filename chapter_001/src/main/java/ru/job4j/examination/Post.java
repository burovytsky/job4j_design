package ru.job4j.examination;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Post {
    public static Map<User, Set<String>> merge(Map<User, Set<String>> map) {
        Map<User, Set<String>> result = new HashMap<>();
        Map<String, User> backward = new HashMap<>();
        for (Map.Entry<User, Set<String>> mails : map.entrySet()) {
            User user = null;
            for (String element : mails.getValue()) {
                if (backward.containsKey(element)) {
                    user = backward.get(element);
                    break;
                }
            }
            if (user != null) {
                result.get(user).addAll(mails.getValue());
                for (String current : mails.getValue()) {
                    backward.put(current, user);
                }
            } else {
                user = mails.getKey();
                result.put(user, new HashSet<>());
                result.get(user).addAll(mails.getValue());
                for (String gr : mails.getValue()) {
                    backward.put(gr, user);
                }
            }
        }
        return result;
    }
}
