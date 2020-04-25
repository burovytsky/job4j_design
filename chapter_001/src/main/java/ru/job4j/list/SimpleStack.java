package ru.job4j.list;

import java.util.Iterator;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        T value = null;
        for (T item : linked) {
            value = item;
        }
        linked.deleteLast();
        return value;
    }

    public void push(T value) {
        linked.add(value);
    }
}
