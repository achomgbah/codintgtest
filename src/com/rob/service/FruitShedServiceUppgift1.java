package com.rob.service;

import com.rob.model.FruitShed;
import java.util.Collections;

public class FruitShedServiceUppgift1 implements FruitShedService{
    private Bootstrap bootstrap;

    public FruitShedServiceUppgift1(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    @Override
    public FruitShed getFruitShedWithLowestPrice() {
        Collections.sort(bootstrap.getListFruitSheds());
        FruitShed lowest = bootstrap.getListFruitSheds().get(0);
        System.out.println("id: " + lowest.getId());
        return lowest;
    }
}
