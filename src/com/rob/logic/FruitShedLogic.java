package com.rob.logic;

import com.rob.model.Basket;
import com.rob.model.FruitShed;

import java.util.ArrayList;
import java.util.List;

public class FruitShedLogic {
    public static boolean validateBasket(Basket basket) {
        return basket != null;
    }

    public static List<String> boughtFruits(FruitShed fruitShed) {
        Basket pears = fruitShed.getPears();
        Basket peaches = fruitShed.getPeaches();
        Basket cherries = fruitShed.getCherries();

        long priceOfPearBasket = fruitShed.getPriceOfPearBasket();
        long priceOfCherryBasket = fruitShed.getPriceOfCherryBasket();
        long priceOfPeachBasket = fruitShed.getPriceOfPeachBasket();

        List<String> boughtFruits = new ArrayList<>();

        if (validateBasket(pears)) {
            boughtFruits.add(pears.getFruit() + ", price:" + priceOfPearBasket);
        }

        if (validateBasket(cherries) && validateBasket(peaches)) {
            if (priceOfCherryBasket < priceOfPeachBasket) {
                boughtFruits.add(cherries.getFruit()+ ", price: " + priceOfCherryBasket);
                return boughtFruits;
            }
            boughtFruits.add(peaches.getFruit()+ ", price: " + priceOfPeachBasket);
            return boughtFruits;
        }

        if (validateBasket(cherries)) {
            boughtFruits.add(cherries.getFruit()+ ", price: " + priceOfCherryBasket);
        }

        if (validateBasket(peaches)) {
            boughtFruits.add(peaches.getFruit()+ ", price: " + priceOfPeachBasket);
        }
        return boughtFruits;
    }

    public static long getTotal(FruitShed fruitShed){
        Basket pears = fruitShed.getPears();
        Basket peaches = fruitShed.getPeaches();
        Basket cherries = fruitShed.getCherries();

        long priceOfPearBasket = fruitShed.getPriceOfPearBasket();
        long priceOfCherryBasket = fruitShed.getPriceOfCherryBasket();
        long priceOfPeachBasket = fruitShed.getPriceOfPeachBasket();

        long total = 0;
        if (validateBasket(pears)) {
            total+= priceOfPearBasket;
        }

        //if all 3 fruits are present, pick the fruit combination with the lowest price
        if (validateBasket(cherries) && validateBasket(peaches)) {
            total += Math.min(priceOfCherryBasket, priceOfPeachBasket);
            return total;
        }

        if (validateBasket(cherries)) {
            total += priceOfCherryBasket;
        }

        if (validateBasket(peaches)) {
            total += priceOfPeachBasket;
        }
        return total;
    }
}
