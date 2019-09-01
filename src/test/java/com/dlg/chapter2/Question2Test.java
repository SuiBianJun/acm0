package com.dlg.chapter2;

import com.dlg.utils.ArrayUtil;
import org.junit.Test;

public class Question2Test {

    int arr[] = new int[]{4, 3, 1, 5, 7, 2};

    @Test
    public void createBigHeapTest(){

        new Question2().createBigHeap(arr);
        ArrayUtil.printArr(arr);

    }

    @Test
    public void createTinyHeapTest(){

        new Question2().createTinyHeap(arr);
        ArrayUtil.printArr(arr);

    }

    @Test
    public void heapfiyBigTest(){

        new Question2().createBigHeap(arr);
        ArrayUtil.printArr(arr);

        new Question2().heapfiyBigHeap(arr, arr.length - 1);
        ArrayUtil.printArr(arr);

        new Question2().heapfiyBigHeap(arr, arr.length - 2);
        ArrayUtil.printArr(arr);

    }

    @Test
    public void heapfiyTinyTest(){

        new Question2().createTinyHeap(arr);
        ArrayUtil.printArr(arr);

        new Question2().heapfiyTinyHeap(arr, arr.length - 1);
        ArrayUtil.printArr(arr);

        new Question2().heapfiyTinyHeap(arr, arr.length - 2);
        ArrayUtil.printArr(arr);

    }

    @Test
    public void getMiddleTest(){
        new Question2().getMiddle();
    }

}
