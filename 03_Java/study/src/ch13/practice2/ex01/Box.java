package ch13.practice2.ex01;

public class Box<T> {
    private T t;

    public T get () {
        return t;
    }

    public void set (T t) {
        this.t = t;
    }
}