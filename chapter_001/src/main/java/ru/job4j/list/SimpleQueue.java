package ru.job4j.list;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int inSize = 0;
    private int outSize = 0;

    public T poll() {
        while (inSize > outSize){
            out.push(in.pop());
            outSize++;
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        inSize++;
    }

}
