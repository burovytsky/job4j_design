package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {
    @Test
    public void whenAddTwoSameObjectsThenPrint() {
        Map<User, Object> userObjectMap = new HashMap<>();
        User user1 = new User("User1", 2, new GregorianCalendar(1985, Calendar.MARCH, 23));
        User user2 = new User("User1", 2, new GregorianCalendar(1985, Calendar.MARCH, 23));
        userObjectMap.put(user1, new Object());
        userObjectMap.put(user2, new Object());
        for (Map.Entry<User, Object> us : userObjectMap.entrySet()) {
            System.out.println(us.getKey() + " " + us.getValue());
        }
    }
}