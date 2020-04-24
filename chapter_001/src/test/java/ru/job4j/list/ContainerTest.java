package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ContainerTest {

    @Test
    public void whenAddThenGetShouldReturnAddedItem() {
        Container<String> container = new Container();
        String testString = "test";
        container.add(testString);
        assertThat(testString, is(container.get(0)));
    }

    @Test
    public void whenIteratorNext() {
        Container<String> container = new Container();
        container.add("testString1");
        container.add("testString2");
        container.add("testString3");
        String rsl = (String) container.iterator().next();
        assertThat(rsl, is("testString1"));
    }

    @Test
    public void whenIteratorHasNextShouldReturnFalse() {
        Container<String> container = new Container();
        container.add("s1");
        boolean rsl = container.iterator().hasNext();
        assertThat(rsl, is(false));
    }
    @Test
    public void whenIteratorHasNextShouldReturnTrue() {
        Container<String> container = new Container();
        container.add("s1");
        container.add("s2");
        boolean rsl = container.iterator().hasNext();
        assertThat(rsl, is(true));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenCalledIndexOutOfBoundsException() {
        Container<String> container = new Container();
        String testString = "test";
        container.add(testString);
        assertThat(testString, is(container.get(2)));
    }
}