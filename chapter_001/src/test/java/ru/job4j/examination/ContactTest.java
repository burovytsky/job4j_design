package ru.job4j.examination;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void grouping() {
        List<String> test = List.of("111;123;222", "200;123;100", "300;;100", "22;33;44", "55;23", "11;17;22");
        Map<String, Set<String>> rsl = Contact.grouping(test);

        for (Map.Entry<String, Set<String>> map1 : rsl.entrySet()) {
            System.out.println(map1.getKey() + " " + map1.getValue());
        }
    }
}