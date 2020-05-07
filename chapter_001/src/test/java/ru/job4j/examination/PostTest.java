package ru.job4j.examination;


import org.junit.Test;
import ru.job4j.examination.Post;
import ru.job4j.examination.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PostTest {
    @Test
    public void whenEq() {
        Set<String> list1 = Set.of("email4", "email3");
        Set<String> list2 = Set.of("email1", "email4");
        Set<String> list3 = Set.of("email5", "email6");
        Set<String> list4 = Set.of("email4", "email7");
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        Map<User, Set<String>> map = new HashMap<>();
        map.put(user1, list1);
        map.put(user2, list2);
        map.put(user3, list3);
        map.put(user4, list4);
        for (Map.Entry<User, Set<String>> map1 : map.entrySet()) {
            System.out.println(map1.getKey() + " " + map1.getValue());
        }
        Map<User, Set<String>> sort = Post.merge(map);
        System.out.println();
        for (Map.Entry<User, Set<String>> map1 : sort.entrySet()) {
            System.out.println(map1.getKey() + " " + map1.getValue());
        }
    }

}