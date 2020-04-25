package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects = new Object[10];
    private int index = 0;
    private int point = 0;
    private int modCount = 0;

    public void add(T element) {
        if (index >= objects.length) {
            int newSize = (int) (objects.length + objects.length * 1.5);
            objects = Arrays.copyOf(objects, newSize);
        }
        this.objects[index++] = element;
        modCount++;
    }

    public T get(int position) {
        if (position < 0 || position >= objects.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object target = this.objects[position];
        if ((T) target == null) {
            throw new NoSuchElementException();
        }
        return (T) target;
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModCount = modCount;
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return objects.length > point;
            }

            @Override
            public T next() {
                if (!hasNext() || objects[point] == null) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) objects[point++];
            }
        };
    }
}
