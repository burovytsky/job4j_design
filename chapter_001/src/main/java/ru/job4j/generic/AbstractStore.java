package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private final Store<T> store;

    public AbstractStore() {
        this.store = new MemStore<>();
    }

    @Override
    public void add(T model) {
        this.store.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return this.store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return this.store.delete(id);
    }

    @Override
    public T findById(String id) {
        return this.store.findById(id);
    }
}
