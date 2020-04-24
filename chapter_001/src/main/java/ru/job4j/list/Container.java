package ru.job4j.list;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Container<E> implements Iterable {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;
    private int modCount = 0;
    private int expectedModCount = 0;

    public Container() {
        this.lastNode = new Node(firstNode, null, null);
        this.firstNode = new Node(null, null, lastNode);
    }

    public void add(E value) {
        Node<E> lastTemp = lastNode;
        lastTemp.currentElement = value;
        lastNode = new Node(lastTemp, null, null);
        lastTemp.nextElement = lastNode;
        size++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> target = firstNode.nextElement;
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.currentElement;
    }

    private Node<E> getNextElement(Node<E> currentElement) {
        return currentElement.nextElement;
    }

    @Override
    public Iterator iterator() {
        expectedModCount = modCount;
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
        E currentElement;
        Node<E> nextElement;
        Node<E> prevElement;

        public Node(Node<E> prevElement, E currentElement, Node<E> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }
    }
}
