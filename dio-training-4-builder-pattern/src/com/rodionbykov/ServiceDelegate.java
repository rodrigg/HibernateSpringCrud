package com.rodionbykov;

import java.util.Arrays;

/**
 * Created by Rodion Bykov on 06.05.2014.
 */
public class ServiceDelegate {

    private final CoffeeMachine resource;

    public ServiceDelegate(CoffeeMachine resource){
        this.resource = resource;
    }

    public CoffeeCup[] merge(CoffeeCup[] a, CoffeeCup[] b){

        CoffeeCup[] c = new CoffeeCup[] {};

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        c = resource.merge(a, b);

        return c;
    }

}
