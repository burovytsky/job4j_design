package ru.job4j.set;

import ru.job4j.list.SimpleArray;
import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArray<E> simpleArray = new SimpleArray<>();
    private int size = 0;

    public void add(E element) {
        boolean rsl = true;
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (simpleArray.get(i).equals(element)) {
                    rsl = false;
                    break;
                }
            }
        }
        if (rsl) {
            simpleArray.add(element);
            size++;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return simpleArray.iterator();
    }
}
