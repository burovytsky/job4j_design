package ru.job4j.analysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analysis {

    public static Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, String> map = new HashMap<>();
        for (User user : current) {
            map.put(user.id, user.name);
        }
        for (User prevUser : previous) {
            String userValue = map.get(prevUser.id);
            if (userValue == null) {
                info.deleted++;
            } else if (!userValue.equals(prevUser.name)) {
                info.changed++;
            }
        }

        info.added = current.size() - previous.size() - info.deleted;
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
