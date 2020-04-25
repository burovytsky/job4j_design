package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    private final int[] array;
    private int index = 0;

    public EvenIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        for (int i = index; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                index = i;
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }
}
