package com.rob.model;

public class Basket {
    private Fruit fruit;

    public Basket(Fruit fruit) {
        this.fruit = fruit;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "fruit=" + fruit +
                '}';
    }
}
