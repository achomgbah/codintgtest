package com.rob.service;

import com.rob.logic.FruitShedLogic;
import com.rob.model.FruitShed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FruitshedServiceUttokning implements FruitShedService {

    private Bootstrap bootstrap;

    public FruitshedServiceUttokning(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    @Override
    public FruitShed getFruitShedWithLowestPrice() {
        List<FruitShed> fruitShedsWithPear = new ArrayList<>();

        // remove sheds without pear
        bootstrap.getListFruitSheds().forEach(fruitShed -> {
            if (fruitShed.getPears() != null) {
                fruitShedsWithPear.add(fruitShed);
            }
        });
        Collections.sort(fruitShedsWithPear);
        FruitShed lowestPrice = fruitShedsWithPear.get(0);
        System.out.println("++++ Utökning 1 +++++");
        System.out.println("id: " + lowestPrice.getId() + "\nPrice: " + FruitShedLogic.getTotal(lowestPrice) +"\n");

        System.out.println("++++ Utökning 2 +++++");
        System.out.println("id: " + lowestPrice.getId() + "\nPrice: " + FruitShedLogic.getTotal(lowestPrice));
        System.out.println(FruitShedLogic.boughtFruits(lowestPrice) + "\n");

        System.out.println("++++ Utökning 3 +++++");
        System.out.println("id: " + lowestPrice.getId() + "\nPrice: " + FruitShedLogic.getTotal(lowestPrice));
        System.out.println(FruitShedLogic.boughtFruits(lowestPrice));
        System.out.println("No. of stores searched: " + fruitShedsWithPear.size());

        getFruitShedWithLowestAfterPurchase(fruitShedsWithPear);
        return lowestPrice;
    }

    public void getFruitShedWithLowestAfterPurchase(List<FruitShed> fruitSheds) {

        //if list is empty, there are no stores with fruits[pear and cherry or peach]
        if (fruitSheds.isEmpty() || fruitSheds.size() == 1) {
            System.out.println("All fruits have been bought sorry..");
            return;
        }

        fruitSheds.remove(0);
        Collections.sort(fruitSheds);
        FruitShed lowestPrice = fruitSheds.get(0);

        System.out.println("++++ Utökning 4 +++++");
        System.out.println("id: " + lowestPrice.getId() + "\nPrice: " + FruitShedLogic.getTotal(lowestPrice));
        System.out.println(FruitShedLogic.boughtFruits(lowestPrice));
        System.out.println("No. of stores searched: " + fruitSheds.size());
    }
}
