package com.rob.model;

import com.rob.logic.FruitShedLogic;

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
        return FruitShedLogic.getTotal(this) < FruitShedLogic.getTotal(o) ? -1 : 0;
    }

    @Override
    public String toString() {
        return "FruitShed{" +
                "cherries=" + cherries +
                ", peaches=" + peaches +
                ", id=" + id +
                ", priceOfCherryBasket=" + priceOfCherryBasket +
                ", priceOfPeachBasket=" + priceOfPeachBasket +
                ", total=" + FruitShedLogic.getTotal(this) +
                '}';
    }
}
