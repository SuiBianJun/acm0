package com.dlg.chapter2;

import org.junit.Test;

public class SortTest {

    int[] arr = new int[]{3, 1, 5, 5, 5, 5, 7, 8, 2, 0, 0, 0, 0, 0};

    @Test
    public void partionTest(){

        new Sort().partion(arr, 5);

        printArr(arr);

    }

    @Test
    public void partionTest2(){

        int[] result = new Sort().partion2(arr, 5, 0, 5);

        printArr(arr);
        System.out.println();
        printArr(result);

    }

    public void printArr(int arr[]){
        for(int x : arr){
            System.out.print(x + " ");
        }
    }

    // 经典quikSort
    @Test
    public void quickSortTest(){
        new Sort().quickSort(arr, arr[arr.length - 1], 0, arr.length - 1);
        printArr(arr);
    }


    // 经典quikSort改进划分过程
    @Test
    public void quickSort2Test(){
        new Sort().quickSort2(arr, arr[arr.length - 1], 0, arr.length - 1);
        printArr(arr);
    }
}
