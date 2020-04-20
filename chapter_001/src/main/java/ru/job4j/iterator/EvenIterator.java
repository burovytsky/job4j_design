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
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Object next() {
        Object rsl = null;
        for (int i = index; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                rsl = array[i];
                index = i + 1;
                break;
            }
        }
        if (rsl == null){
            throw new NoSuchElementException();
        }
        return rsl;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
