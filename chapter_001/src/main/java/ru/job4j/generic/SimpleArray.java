package ru.job4j.generic;

import java.util.ConcurrentModificationException;
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
        Objects.checkIndex(position, index);
        return (T) this.objects[position];
    }

    public void set(int position, T element) {
        Objects.checkIndex(position, index);
        this.objects[position] = element;
    }

    public void remove(int position) {
        Objects.checkIndex(position, index);
        System.arraycopy(objects, position + 1, objects, position,  index - 1 - position);
        objects[objects.length - 1] = null;
        index--;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModCount = modCount;
        return new Iterator<T>() {
            private int point = 0;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
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
