package ru.job4j.tdd.kissdryyagni;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        T max = value.get(0);
        for (int i = 0; i < value.size(); i++) {
            if (comparator.compare(max, value.get(i)) < 0) {
                max = value.get(i);
            }
        }
        return max;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        T min = value.get(0);
        for (int i = 0; i < value.size(); i++) {
            if (comparator.compare(min, value.get(i)) > 0) {
                min = value.get(i);
            }
        }
        return min;
    }
}
