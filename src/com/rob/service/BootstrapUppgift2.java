package com.rob.service;

import com.rob.model.Basket;
import com.rob.model.Fruit;
import com.rob.model.FruitShed;

import java.util.Arrays;
import java.util.List;

public class BootstrapUppgift2 implements Bootstrap{
    private Fruit cherry = new Fruit("cherry");
    private Fruit peach = new Fruit("peach");
    private Fruit pear = new Fruit("pear");

    private Basket cherryBasket = new Basket(cherry);
    private Basket peachBasket = new Basket(peach);
    private Basket pearBasket = new Basket(pear);

    private FruitShed fruitShedA = new FruitShed(cherryBasket, peachBasket,null, 1, 20, 30, 15);
    private FruitShed fruitShedB = new FruitShed(null, peachBasket,pearBasket, 2, 70, 80, 14);
    private FruitShed fruitShedC = new FruitShed(cherryBasket, null,pearBasket, 3, 10, 80, 30);

    //assert that if all 3 fruits are present, it picks right combination[change prices to test]
    private FruitShed fruitShedD = new FruitShed(cherryBasket, peachBasket,pearBasket, 4, 14, 25,30);

    // assert that stores without any fruits does not break
    private FruitShed fruitShedE = new FruitShed(null, null,null, 5, 0, 0,0);

    private List<FruitShed> fruitSheds = Arrays.asList(fruitShedB, fruitShedA,fruitShedD, fruitShedC, fruitShedE);

    @Override
    public List<FruitShed> getListFruitSheds() {
        return fruitSheds;
    }
}
