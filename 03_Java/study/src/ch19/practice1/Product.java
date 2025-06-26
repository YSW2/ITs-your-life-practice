package ch19.practice1;

public interface Product extends Cloneable {
    void use (String s);

    Product createCopy ();
    
}