package com.rodionbykov;

import java.util.Arrays;

/**
 * Created by Rodion Bykov on 24.04.2014.
 */
public class CoffeeMain {

    public static void main(String[] args) {

        // let's prepare some coffee for all guys
        CoffeeCup tallCappuccino = new CoffeeCup.Builder().coffeeType(CoffeeType.CAPPUCCINO).sugar(2).volume(250).build();
        CoffeeCup largeCappuccino = new CoffeeCup.Builder().coffeeType(CoffeeType.CAPPUCCINO).sugar(2).volume(200).build();
        CoffeeCup smallCappuccino = new CoffeeCup.Builder().coffeeType(CoffeeType.CAPPUCCINO).sugar(1).volume(100).build();
        CoffeeCup tallLatte = new CoffeeCup.Builder().coffeeType(CoffeeType.LATTE).sugar(2).volume(250).build();
        CoffeeCup largeLatte = new CoffeeCup.Builder().coffeeType(CoffeeType.LATTE).sugar(2).volume(200).build();
        CoffeeCup smallLatte = new CoffeeCup.Builder().coffeeType(CoffeeType.LATTE).sugar(1).volume(100).build();
        CoffeeCup espresso = new CoffeeCup.Builder().coffeeType(CoffeeType.BLACK).sugar(1).volume(50).build();
        CoffeeCup doubleEspresso = new CoffeeCup.Builder().coffeeType(CoffeeType.BLACK).sugar(2).volume(100).build();


        CoffeeCup[] coffeeCups1 = new CoffeeCup[] {largeCappuccino, largeLatte, smallLatte, espresso, doubleEspresso};
        CoffeeCup[] coffeeCups2 = new CoffeeCup[] {tallCappuccino, smallCappuccino, tallLatte};
        CoffeeCup[] coffeeCups3 = new CoffeeCup[] {};

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        ServiceDelegate serviceDelegate = new ServiceDelegate(coffeeMachine);

        coffeeCups3 = serviceDelegate.merge(coffeeCups1, coffeeCups2);

        System.out.println(Arrays.toString(coffeeCups3));

        // let's sip some coffee
        //coffeeCup1.drink(50);

        //System.out.println(coffeeCup1);

        // great coffee, let's refill cup with 1 sugar cube and 100ml

        //coffeeCup1.refill(1, 100);

        //System.out.println(coffeeCup1);

    }

}
