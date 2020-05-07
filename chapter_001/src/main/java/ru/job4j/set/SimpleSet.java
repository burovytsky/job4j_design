package ru.job4j.set;

import ru.job4j.list.SimpleArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArray<E> simpleArray = new SimpleArray<>();
    private int size = 0;

    public void add(E element) {
        if (!contains(element)) {
            simpleArray.add(element);
            size++;
        }
    }

    public boolean contains(E element) {
        boolean rsl = false;
        if (size == 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (simpleArray.get(i).equals(element)) {
                rsl = true;
                break;
            }
        }
//        Iterator<E> it = simpleArray.iterator();
//        while (it.hasNext()) {
//            if (it.next().equals(element)) {
//                rsl = true;
//                break;
//            }
//        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return simpleArray.iterator();
    }
}