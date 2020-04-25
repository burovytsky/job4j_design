package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            Iterator<Integer> iterator = it.next();

            @Override
            public boolean hasNext() {
                boolean rsl = false;
                while (it.hasNext() && !iterator.hasNext()) {
                    iterator = it.next();
                }
                if (iterator != null) {
                    rsl = iterator.hasNext();
                }
                return rsl;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }
        };
    }
}
