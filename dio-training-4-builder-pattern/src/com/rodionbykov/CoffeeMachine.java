package com.rodionbykov;

import java.util.Arrays;

public class CoffeeMachine {

    public CoffeeMachine(){

    }

    public CoffeeCup[] merge(CoffeeCup[] a, CoffeeCup[] b){
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
