package ru.job4j.tdd;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void max() {
        List<Integer> integerList = List.of(2, 3, 4, 1, 8, 3, 23, 4, 22, 21, 4);
        int rsl = new MaxMin().max(integerList, Integer::compareTo);
        assertThat(rsl, is(23));
    }

    @Test
    public void min() {
        List<Integer> integerList = List.of(12, 2, 4, 1, 8, 3, 23, 4, 22);
        int rsl = new MaxMin().min(integerList, Integer::compareTo);
        assertThat(rsl, is(1));
    }
}