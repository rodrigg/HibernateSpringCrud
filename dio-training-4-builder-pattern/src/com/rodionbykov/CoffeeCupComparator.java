package com.rodionbykov;

import java.util.Comparator;

public class CoffeeCupComparator implements Comparator<CoffeeCup> {

    @Override
    public int compare(CoffeeCup a, CoffeeCup b) {
        return a.getVolume() == b.getVolume() ? 0 : (a.getVolume() > b.getVolume() ? 1 : -1);
    }

}