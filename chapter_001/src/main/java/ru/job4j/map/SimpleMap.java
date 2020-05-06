package ru.job4j.map;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Iterable<SimpleMap.Node<K, V>> {
    private Node<K, V>[] table = new Node[16];
    private int size;
    private int modCount;
    private float threshold =  table.length * 0.75f;

    public boolean insert(K key, V value) {
        int hash = hash(key);
        if (size + 1 > threshold) {
            tableDoubling();
        }
        int i = forIndex(hash);

        if (table[i] == null) {
            Node<K, V> node = new Node<K, V>(key, value, hash);
            table[i] = node;
            size++;
            modCount++;
            return true;
        }
        return false;
    }

    public V get(K key) {
        V value = null;
        int i = forIndex(hash(key));
        Node<K, V> node = table[i];
        if (node != null) {
            if ((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                value = node.value;
            }
        }
        return value;
    }

    public boolean delete(K key) {
        boolean rsl = false;
        int i = forIndex(hash(key));
        Node<K, V> node = table[i];
        if (node != null) {
            if ((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                table[i] = null;
                rsl = true;
                size--;
                modCount++;
            }
        }
        return rsl;
    }

    private void tableDoubling() {
            Node<K, V>[] oldTable = table;
            table = new Node[table.length * 2];
            threshold = table.length * 0.75f;
            for (Node node : oldTable) {
                if (node != null) {
                    table[forIndex(node.hash)] = node;
                }
            }
    }

    private int forIndex(int hash) {
        return (table.length - 1) & hash;
    }

    static final int hash(Object key) {
        int rsl;
        if (key == null) {
            rsl = 0;
        } else {
            int h = key.hashCode();
            rsl = h ^ (h >>> 16);
        }
        return rsl;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            int expectedModCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                boolean rsl = false;
                for (int i = index; i < table.length; i++) {
                    if (table[i] != null) {
                        index = i;
                        rsl = true;
                        break;
                    }
                }
                return rsl;
            }

            @Override
            public Node<K, V> next() throws NoSuchElementException, ConcurrentModificationException {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++];
            }
        };
    }

    static class Node<K, V> {
        final K key;
        V value;
        final int hash;

        Node(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }
}