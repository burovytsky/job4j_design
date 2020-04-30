package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenAddThenIt() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        Iterator<String> iterator = array.iterator();
        assertThat(iterator.next(), is("first"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenAddSameElementItsNotAdded() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        array.add("first");
        array.add("second");
        Iterator<String> iterator = array.iterator();
        assertThat(iterator.next(), is("first"));
        assertThat(iterator.next(), is("second"));
        iterator.next();
    }

    @Test
    public void whenContainsShouldReturnTrue() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        array.add("second");
        array.add("third");
        array.add("third");
        assertThat(array.contains("second"), is(true));
    }

}