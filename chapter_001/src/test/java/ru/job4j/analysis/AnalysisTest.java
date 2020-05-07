package ru.job4j.analysis;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import static ru.job4j.analysis.Analysis.*;

public class AnalysisTest {

    @Test
    public void whenAdded2Changed1Deleted2() {
        User user1 = new User(1, "user1");
        User user2 = new User(2, "user2");
        User user3 = new User(3, "user3");
        User user4 = new User(4, "user4");
        User user5 = new User(5, "user5");
        User user6 = new User(6, "user6");
        User user7 = new User(7, "user6");
        List<User> previous = List.of(user1, user2, user3, user4);
        user1 = new User(1, "userNew");
        List<User> current = List.of(user1, user3, user5, user6, user7);
        Analysis.Info info = Analysis.diff(previous, current);
        assertThat(3, is(info.added));
        assertThat(1, is(info.changed));
        assertThat(2, is(info.deleted));
    }
}