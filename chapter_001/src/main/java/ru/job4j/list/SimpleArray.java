package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int indexForArray = 0;
    private int indexForIterator = 0;
    private int modCount = 0;
    private int expectedModCount = 0;

    public SimpleArray() {
        this.objects = new Object[10];
    }

    public void add(T element) {
        if (indexForArray >= objects.length) {
            int newSize = (int) (objects.length + objects.length * 1.5);
            objects = Arrays.copyOf(objects, newSize);
        }
        this.objects[indexForArray++] = element;
        modCount++;
    }

    public T get(int position) {
        if ((T) this.objects[position] == null) {
            throw new NoSuchElementException();
        }
        return (T) this.objects[position];
    }

    @Override
    public Iterator<T> iterator() {
        expectedModCount = modCount;
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return objects.length > indexForIterator;
            }

            @Override
            public T next() {
                if (!hasNext() || objects[indexForIterator] == null) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) objects[indexForIterator++];
            }
        };
    }
}
