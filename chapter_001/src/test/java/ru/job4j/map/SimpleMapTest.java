package ru.job4j.map;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenInsertThenGetIt() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.insert("test", 1);
        var rsl = map.get("test");
        assertThat(rsl, is(1));
    }

    @Test
    public void whenDeleteShouldReturnNull() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.insert("test1", 1);
        map.insert("test2", 2);
        var rsl = map.get("test2");
        assertThat(rsl, is(2));
        assertThat(map.delete("test2"), is(true));
    }

    @Test
    public void whenIterateShouldReturnNext() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.insert("test1", 1);
        map.insert("test2", 2);
        var it = map.iterator();
        assertThat(it.next().key, is("test2"));
        assertThat(it.next().value, is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIterateShouldNoSuchElementException() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.insert("test1", 1);
        var it = map.iterator();
        it.next();
        it.next();

    }
}