package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;



    public void add(T value) {
        size++;
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> temp = head;
        head = head.next;
        temp.next = null;
        size--;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        size--;
        T rsl = head.value;
        if (head.next == null) {
            head = null;
            return rsl;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            if (temp.next.next == null) {
                rsl = temp.next.value;
                temp.next = null;
                break;
            }
            temp = temp.next;
        }
        return rsl;
    }

    public void revert() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next;
        while (current != null) {
            next = current.next;
            if (next == null) {
                head = current;
            }
            current.next = prev;
            prev = current;
            current = next;
        }
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
