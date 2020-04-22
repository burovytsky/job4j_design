package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int indexForArray = 0;
    private int indexForIterator = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T element) {
        if (indexForArray > objects.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.objects[indexForArray++] = element;
    }

    public T get(int position) {
        if(position >= objects.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) this.objects[position];
    }

    public void set(int position, T element) {
        if(position >= objects.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        this.objects[position] = element;
    }

    public void remove(int position) {
        for (int i = position; i < objects.length - 1; i++) {
            objects[i] = objects[i + 1];
        }
        objects[objects.length - 1] = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return objects.length > indexForIterator;
            }

            @Override
            public T next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                return (T) objects[indexForIterator++];
            }
        };
    }
}
