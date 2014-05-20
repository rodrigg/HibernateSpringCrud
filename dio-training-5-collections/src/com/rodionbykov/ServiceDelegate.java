package com.rodionbykov;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Rodion Bykov on 06.05.2014.
 */
public class ServiceDelegate {

    private final CoffeeMachine resource;

    public ServiceDelegate(CoffeeMachine resource){
        this.resource = resource;
    }

    public HashSet<CoffeeCup> mergeSets(HashSet<CoffeeCup> a, HashSet<CoffeeCup> b){

        HashSet<CoffeeCup> c = new HashSet<CoffeeCup>();

        System.out.println(a.toString());
        System.out.println(b.toString());
        c = resource.mergeSets(a, b);

        return c;
    }

    public CoffeeCup[] mergeArrays(CoffeeCup[] a, CoffeeCup[] b){

        CoffeeCup[] c = new CoffeeCup[] {};

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        c = resource.mergeArrays(a, b);

        return c;
    }

}
