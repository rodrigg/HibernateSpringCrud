package com.rodionbykov;

import java.util.Arrays;

public class ArraysExtra {

    public static int[] merge(int[] a, int[] b){

        int[] c = new int[] {};

        if (a != null && b != null) {
            for (int i : a) {
                boolean found = false;
                for (int k : c) {
                    if (k == i) {
                        found = true;
                    }
                }
                if (!found) {
                    c = Arrays.copyOf(c, c.length + 1);
                    c[c.length - 1] = i;
                }
            }

            for (int j : b) {
                boolean found = false;
                for (int k : c) {
                    if (k == j) {
                        found = true;
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

    public static int[] innerJoin(int[] a, int[] b){

        int[] c = new int[] {};

        for(int i : a){
            for(int j : b){
                if(i == j){
                    boolean found = false;
                    for(int k : c){
                        if (k == i){
                            found = true;
                        }
                    }
                    if(!found) {
                        c = Arrays.copyOf(c, c.length + 1);
                        c[c.length - 1] = j;
                    }
                }
            }
        }

        return c;

    }

    public static int[] outerJoin(int[] a, int[] b){

        int[] c = new int[] {};

        int[] merged = ArraysExtra.merge(a, b);
        int[] joined = ArraysExtra.innerJoin(a, b);

        boolean found = false;
        for(int i : merged){
            found = false;
            for(int j : joined){
                if(i == j){
                    found = true;
                }
            }
            if(!found) {
                c = Arrays.copyOf(c, c.length + 1);
                c[c.length - 1] = i;
            }
        }

        return c;

    }

}
