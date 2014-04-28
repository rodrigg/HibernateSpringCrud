package com.rodionbykov;

import java.util.Arrays;

/**
 * Created by Rodion Bykov on 28.04.2014.
 */
public class DioJava3 {

    public static void main(String[] args){

        int[] array1 = {1,5,4,23,65,32,78};
        int[] array2 = {3,5,24,54,1,2,34,45,32};

        int[] merged = ArraysExtra.merge(array1, array2);
        System.out.println(Arrays.toString(merged));

        int[] array3 = {1,5,4,23,65,32,78};
        int[] array4 = {3,5,24,4,1,2,34,45,32,5};

        int[] innerjoined = ArraysExtra.innerJoin(array3, array4);
        System.out.println(Arrays.toString(innerjoined));

        int[] array5 = {1,5,4,23,65,32,78};
        int[] array6 = {3,5,24,4,1,2,34,45,32,5};

        int[] outerjoined = ArraysExtra.outerJoin(array5, array6);
        System.out.println(Arrays.toString(outerjoined));

    }

}
