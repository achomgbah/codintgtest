package com.rob;

import com.rob.service.*;

public class Main {

    public static void main(String[] args) {

        BootstrapUppgift1 db = new BootstrapUppgift1();
        BootstrapUppgift2 db2 = new BootstrapUppgift2();

        FruitShedServiceUppgift1 uppgift1 = new FruitShedServiceUppgift1(db);
        FruitshedServiceUttokning uttokning = new FruitshedServiceUttokning(db2);

        UppgiftRunner.run(uppgift1);
        UppgiftRunner.run(uttokning);
    }
}
