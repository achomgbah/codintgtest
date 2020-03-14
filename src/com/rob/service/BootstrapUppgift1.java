package com.rob.service;

import com.rob.model.Basket;
import com.rob.model.Fruit;
import com.rob.model.FruitShed;

import java.util.Arrays;
import java.util.List;

public class BootstrapUppgift1 implements Bootstrap{
    private Fruit cherry = new Fruit("cherry");
    private Fruit peach = new Fruit("peach");

    private Basket cherryBasket = new Basket(cherry);
    private Basket peachBasket = new Basket(peach);

    private FruitShed fruitShedA = new FruitShed(cherryBasket, peachBasket,null, 1, 20, 30, 0);
    private FruitShed fruitShedB = new FruitShed(cherryBasket, peachBasket,null, 2, 70, 80, 0);
    private FruitShed fruitShedC = new FruitShed(cherryBasket, peachBasket,null, 3, 10, 80, 0);

    //same price, assert that shed D comes before shed E
    private FruitShed fruitShedD = new FruitShed(cherryBasket, peachBasket,null, 4, 10, 15,0);
    private FruitShed fruitShedE = new FruitShed(cherryBasket, peachBasket,null, 5, 10, 15,0);

    private List<FruitShed> fruitSheds = Arrays.asList(fruitShedB, fruitShedA,fruitShedD, fruitShedC, fruitShedE);

    public Fruit getCherry() {
        return cherry;
    }

    public Fruit getPeach() {
        return peach;
    }

    public Basket getCherryBasket() {
        return cherryBasket;
    }

    public Basket getPeachBasket() {
        return peachBasket;
    }

    @Override
    public List<FruitShed> getListFruitSheds() {
        return fruitSheds;
    }
}
