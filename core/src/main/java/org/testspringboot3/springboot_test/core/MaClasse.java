package org.testspringboot3.springboot_test.core;

public class MaClasse<X> {
    private X x;

    public MaClasse(X x) {
        this.x = x;
    }

    public X getX() {
        return x;
    }
}
