package com.rodionbykov.test;

import com.rodionbykov.ArraysExtra;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DioArrayTest {

    @Test
    public void testMerge() throws Exception{
        int[] array1 = new int[] {1,5,4,23,65,32,78};
        int[] array2 = new int[] {3,5,24,54,1,2,34,45,32};

        int[] merged = ArraysExtra.merge(array1, array2);
        int[] result = new int[] {1,5,4,23,65,32,78,3,24,54,2,34,45};

        Arrays.sort(merged);
        Arrays.sort(result);

        Assert.assertArrayEquals(merged, result);
    }

    @Test
    public void testMergeNull() throws Exception{
        int[] array1 = null;
        int[] array2 = null;

        int[] merged = ArraysExtra.merge(array1, array2);
    }

    @Test
    public void testMergeEmpty() throws Exception{
        int[] array1 = new int[0];
        int[] array2 = new int[] {3,5,24,54,1,2,34,45,32};

        int[] merged = ArraysExtra.merge(array1, array2);

        Assert.assertArrayEquals(array2, merged);
    }

    @Test
    public void testMergeHuge() throws Exception{

    }

    @Test
    public void testMergeDuplicates() throws Exception{
        int[] array1 = {1,1,1,1,2,2,3};
        int[] array2 = {3,3,4,4,5,5,5,5,5,5};

        int[] merged = ArraysExtra.merge(array1, array2);
        int[] result = new int[] {1,2,3,4,5};

        Arrays.sort(merged);
        Arrays.sort(result);

        Assert.assertArrayEquals(merged, result);
    }


    @Test
    public void testMergeDuplicates2() throws Exception{
        int[] array1 = {1,1,1,1,1,1,1};
        int[] array2 = {1,1,1,1,1,1,1,1,1,1};

        int[] merged = ArraysExtra.merge(array1, array2);
        int[] result = new int[] {1};

        Arrays.sort(merged);
        Arrays.sort(result);

        Assert.assertArrayEquals(merged, result);
    }

    @Test
    public void testMergeValidSize() throws Exception{
        int[] array1 = new int[] {1,5,4,23,65,32,78};
        int[] array2 = new int[] {3,5,24,54,1,2,34,45,32};

        int[] merged = ArraysExtra.merge(array1, array2);
        int[] result = new int[] {1,5,4,23,65,32,78,3,24,54,2,34,45};

        Assert.assertEquals(merged.length, result.length);
    }

    @Test
    public void testInnerJoin(){
        int[] array3 = {1,5,4,23,65,32,78};
        int[] array4 = {3,5,24,4,1,2,34,45,32,5};

        int[] innerjoined = ArraysExtra.innerJoin(array3, array4);
        int[] result = new int[] {5,4,32,1};

        Arrays.sort(innerjoined);
        Arrays.sort(result);

        Assert.assertArrayEquals(innerjoined, result);
    }

    @Test
    public void testOuterJoin(){
        int[] array5 = {1,5,4,23,65,32,78};
        int[] array6 = {3,5,24,4,1,2,34,45,32,5};

        int[] outerjoined = ArraysExtra.outerJoin(array5, array6);
        int[] result = new int[] {23,65,78,3,24,2,34,45};

        Arrays.sort(outerjoined);
        Arrays.sort(result);

        Assert.assertArrayEquals(outerjoined, result);
    }


}
