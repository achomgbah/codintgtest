package com.rob.model;

import java.util.ArrayList;
import java.util.List;

public class FruitShed implements Comparable<FruitShed>{
    private Basket cherries;
    private Basket peaches;
    private Basket pears;
    private int id;
    private long priceOfCherryBasket;
    private long priceOfPeachBasket;
    private long priceOfPearBasket;

    public FruitShed(Basket cherries, Basket peaches, Basket pears, int id, long priceOfCherryBasket,long priceOfPeachBasket, long priceOfPearBasket) {
        this.cherries = cherries;
        this.peaches = peaches;
        this.pears = pears;
        this.id = id;
        this.priceOfCherryBasket = priceOfCherryBasket;
        this.priceOfPeachBasket = priceOfPeachBasket;
        this.priceOfPearBasket = priceOfPearBasket;
    }

    public Basket getCherries() {
        return cherries;
    }

    public void setCherries(Basket cherries) {
        this.cherries = cherries;
    }

    public Basket getPeaches() {
        return peaches;
    }

    public void setPeaches(Basket peaches) {
        this.peaches = peaches;
    }

    public Basket getPears() {
        return pears;
    }

    public void setPears(Basket pears) {
        this.pears = pears;
    }

    public long getPriceOfPearBasket() {
        return priceOfPearBasket;
    }

    public void setPriceOfPearBasket(long priceOfPearBasket) {
        this.priceOfPearBasket = priceOfPearBasket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPriceOfCherryBasket() {
        return priceOfCherryBasket;
    }

    public void setPriceOfCherryBasket(long priceOfCherryBasket) {
        this.priceOfCherryBasket = priceOfCherryBasket;
    }

    public long getPriceOfPeachBasket() {
        return priceOfPeachBasket;
    }

    public void setPriceOfPeachBasket(long priceOfPeachBasket) {
        this.priceOfPeachBasket = priceOfPeachBasket;
    }

    @Override
    public int compareTo(FruitShed o) {
        return this.getTotal() < o.getTotal() ? -1 : 0;
    }

    public long getTotal(){
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

    public List<String> boughtFruits() {
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

    private boolean validateBasket(Basket basket) {
        return basket != null;
    }

    @Override
    public String toString() {
        return "FruitShed{" +
                "cherries=" + cherries +
                ", peaches=" + peaches +
                ", id=" + id +
                ", priceOfCherryBasket=" + priceOfCherryBasket +
                ", priceOfPeachBasket=" + priceOfPeachBasket +
                ", total=" + getTotal() +
                '}';
    }
}
