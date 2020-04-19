package ru.job4j.iterator;

import java.util.Iterator;

public class JaggedArrayIterator implements Iterator {
    private final int[][] ints;
    private int indexRow = 0;
    private int indexColumn = 0;

    public int getIndexRow() {
        return indexRow;
    }

    public int getIndexColumn() {
        return indexColumn;
    }

    public JaggedArrayIterator(int[][] ints) {
        this.ints = ints;
    }

    @Override
    public boolean hasNext() {
        return ints.length > indexRow;
    }

    @Override
    public Object next() {
        Object rsl;
        if (ints[indexRow].length > indexColumn) {
            rsl = ints[indexRow][indexColumn++];
        } else {
            indexColumn = 0;
            indexRow++;
            rsl = ints[indexRow][indexColumn++];
        }
        if (ints.length == indexRow + 1) {
            indexRow++;
        }
        return rsl;

    }

}
