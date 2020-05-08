package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;
    private int modCount = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T element) {
        this.objects[index++] = element;
        modCount++;
    }

    public T get(int position) {
        Objects.checkIndex(position, objects.length);
        return (T) this.objects[position];
    }

    public void set(int position, T element) {
        if (position >= objects.length || position < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.objects[position] = element;
    }

    public void remove(int position) {
        System.arraycopy(objects, position + 1, objects, position, objects.length - 1 - position);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int point = 0;
            @Override
            public boolean hasNext() {
                return objects.length > point;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[point++];
            }
        };
    }
}
