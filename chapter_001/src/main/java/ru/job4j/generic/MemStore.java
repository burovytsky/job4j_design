package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        this.mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean rsl = false;
        for (int i = 0; i < mem.size(); i++) {
            if (this.mem.get(i).getId().equals(id)) {
                this.mem.set(i, model);
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        T memItem = findById(id);
        this.mem.remove(memItem);
        rsl = true;
        return rsl;
    }

    @Override
    public T findById(String id) {
        T rsl = null;
        for (T memItem : this.mem) {
            if (memItem.getId().equals(id)) {
                rsl = memItem;
            }
        }
        if (rsl == null) {
            throw new NoSuchElementException();
        }
        return rsl;
    }
}
