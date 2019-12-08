package com.dlg.utils;

import java.util.Arrays;

public class ArrayUtil {

    public static void swap(int[] arr, int l, int r) {

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

    }

    public static void printArr(int arr[]){
//        for(int x : arr){
//            System.out.print(x + " ");
//        }

        Arrays.stream(arr).forEach(value -> System.out.println(value + " "));

        System.out.println();
    }

    public static void printArr(int arr[], String dir){
        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
        System.out.println();
    }

    public static void printArr(int arr[], int s, int length){
        for(int i = s; i < s + length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
