package ch13.practice1.ex02;

public class Product<K, M> {
    public K kind;
    public M model;

    public K getKind () {
        return kind;
    }

    public void setKind (K kind) {
        this.kind = kind;
    }

    public M getModel () {
        return model;
    }

    public void setModel (M model) {
        this.model = model;
    }
}