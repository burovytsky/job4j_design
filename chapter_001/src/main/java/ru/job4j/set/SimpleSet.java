package ru.job4j.set;

import ru.job4j.list.SimpleArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArray<E> set = new SimpleArray<>();

    public void add(E element) {
        if (!contains(element)) {
            set.add(element);
        }
    }

    public boolean contains(E element) {
        boolean rsl = false;
        for (E setElement : set) {
            if (element.equals(setElement)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }
}