package com.rodionbykov;

/**
 * Created by Rodion Bykov on 24.04.2014.
 */
public class CoffeeMain {

    public static void main(String[] args) {

        // let's prepare some coffee - tall latte with 2 sugar cubes
        CoffeeCup coffeeCup1 = new CoffeeCup(CoffeeType.LATTE, 2, 250);

        System.out.println(coffeeCup1);

        // let's prepare some large cup of tea
        TeaCup teaCup1 = new TeaCup(TeaType.EARLGREY, 1, 300);

        System.out.println(teaCup1);

        // let's sip some coffee
        coffeeCup1.drink(50);

        System.out.println(coffeeCup1);

        // great coffee, let's refill cup with 1 sugar cube and 100ml

        coffeeCup1.refill(1, 100);

        System.out.println(coffeeCup1);

        //let's drink some tea
        teaCup1.drink(100);

        System.out.println(teaCup1);

        // yuk, hate tea, let's throw it away

        teaCup1.empty();

        System.out.println(teaCup1);

    }

}
