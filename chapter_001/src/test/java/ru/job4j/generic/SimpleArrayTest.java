package ru.job4j.generic;

import org.junit.Test;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class SimpleArrayTest {

    @Test
    public void whenCreateContainerAndAddElementShouldReturnElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(32);
        simpleArray.add(4);
        int rsl = 32;
        assertThat(rsl, is(simpleArray.get(0)));
    }

    @Test
    public void whenReplaceElementShouldReturnNewElement() {
        SimpleArray<String> simpleArray = new SimpleArray<>(2);
        simpleArray.add("Hi");
        simpleArray.add("Hello");
        simpleArray.set(1, "Bye");
        String rsl = simpleArray.get(1);
        assertThat(rsl, is("Bye"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void invocationAddMethodShouldThrowArrayIndexOutOfBoundsException() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(1);
        simpleArray.add(1);
        simpleArray.add(1);

    }

    @Test
    public void whenRemoveElementShouldShiftByOnePosition() {
        SimpleArray<String> simpleArray = new SimpleArray<>(6);
        simpleArray.add("Hello");
        simpleArray.add("its");
        simpleArray.add("me");
        simpleArray.add("I");
        simpleArray.add("was");
        simpleArray.add("wondering");
        simpleArray.remove(1);
        assertThat("me", is(simpleArray.get(1)));
        simpleArray.remove(1);
        assertThat("was", is(simpleArray.get(2)));
    }

    @Test
    public void iteratorTest() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(4);
        simpleArray.add(1);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(7);
        Iterator<Integer> iterator = simpleArray.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.hasNext(), is(false));
    }
}
