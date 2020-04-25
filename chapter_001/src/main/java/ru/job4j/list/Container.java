package ru.job4j.list;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Container<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;
    private int modCount = 0;

    public Container() {
        this.last = new Node(first, null, null);
        this.first = new Node(null, null, last);
    }

    public void add(E value) {
        Node<E> lastTemp = last;
        lastTemp.element = value;
        last = new Node(lastTemp, null, null);
        lastTemp.next = last;
        size++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> target = first.next;
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.element;
    }

    private Node<E> getNextElement(Node<E> currentElement) {
        return currentElement.next;
    }

    @Override
    public Iterator iterator() {
        int expectedModCount = modCount;
        return new Iterator<E>() {
            int iteratorCounter = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iteratorCounter < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount || get(iteratorCounter) == null) {
                    throw new ConcurrentModificationException();
                }
                return get(iteratorCounter++);
            }
        };
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
