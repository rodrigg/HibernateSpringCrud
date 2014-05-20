package com.rodionbykov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoffeeMachine {

    public CoffeeMachine(){

    }

    public HashSet<CoffeeCup> mergeSets(HashSet<CoffeeCup> a, HashSet<CoffeeCup> b){
        HashSet<CoffeeCup> c = new HashSet<CoffeeCup>();
        c.addAll(a);
        c.addAll(b);
        return c;
    }

    public CoffeeCup[] mergeArrays(CoffeeCup[] a, CoffeeCup[] b){
        CoffeeCup[] c = new CoffeeCup[] {};
        CoffeeCupComparator comparator = new CoffeeCupComparator();

        if (a != null && b != null) {
            for (CoffeeCup i : a) {
                boolean found = false;
                for (CoffeeCup k : c) {
                    if (comparator.compare(k,i) == 0) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    c = Arrays.copyOf(c, c.length + 1);
                    c[c.length - 1] = i;
                }
            }

            for (CoffeeCup j : b) {
                boolean found = false;
                for (CoffeeCup k : c) {
                    if (comparator.compare(k,j) == 0) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    c = Arrays.copyOf(c, c.length + 1);
                    c[c.length - 1] = j;
                }
            }
        }

        return c;
    }

}
