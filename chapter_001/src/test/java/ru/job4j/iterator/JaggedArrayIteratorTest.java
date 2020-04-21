package ru.job4j.iterator;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class JaggedArrayIteratorTest {

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        Iterator<Integer> it = new JaggedArrayIterator(new int[][]{{1}, {3, 4}, {7}});
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    @Test
    public void test() {
        JaggedArrayIterator iterator = new JaggedArrayIterator(new int[][]{{2}});
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false)); }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        Iterator<Integer> it = new JaggedArrayIterator(new int[][]{{1}, {3, 4}, {7}});
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));

    }

    @Test
    public void hasNextNextSequentialInvocation() {
        Iterator<Integer> it = new JaggedArrayIterator(new int[][]{{1}, {3, 4}, {7}});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(false));
    }
}
