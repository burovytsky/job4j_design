package ru.job4j.set;

import ru.job4j.list.SimpleArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArray<E> simpleArray = new SimpleArray<>();

    public void add(E element) {
        if (!contains(element)) {
            simpleArray.add(element);
        }
    }

    public boolean contains(E element) {
        boolean rsl = false;
        Iterator<E> it = simpleArray.iterator();
        while (it.hasNext()) {
            if (it.next().equals(element)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return simpleArray.iterator();
    }
}