package com.dlg.chapter1;

import org.junit.Test;

public class SortTest {

    @Test
    public void bibulSortTest(){
        int[] arr = new int[]{3, 1, 5, 7, 8, 2};
        System.out.println(new Sort().bibulSort(arr));
    }

    @Test
    public void selectSortTest(){
        int[] arr = new int[]{3, 1, 5, 7, 8, 2};
        System.out.println(new Sort().selectSort(arr));
    }

    @Test
    public void insertSortTest(){
        int[] arr = new int[]{3, 1, 5, 7, 8, 2};
        System.out.println(new Sort().insertSort(arr));
    }

    @Test
    public void mergeSortTest(){
        int[] arr = new int[]{3, 1, 5, 7, 8, 2};
        new Sort().mergeSort(arr, 0, arr.length - 1);
    }

}
