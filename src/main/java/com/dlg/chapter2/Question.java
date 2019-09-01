package com.dlg.chapter2;

public class Question {

    // 数组划分：给定一个数num，将数组划分为大于num和小于等于num的两部分

    public void partionArr(int[] arr, int num){

        int l = 0;
        int r = arr.length;

        while(l < r){
            if(arr[l] <= num){
                l++;
            }else{
                swap(arr, l, --r);
            }
        }
    }

    // 数组划分-2：给定一个数num，将数组划分为大于num和小于num以及等于num三部分
    public void partionArr2(int[] arr, int num){

        int currentLessMaxIndex = 0;
        int l = 0;
        int r = arr.length;

        while(l < r){
            if(arr[l] < num){
                swap(arr, currentLessMaxIndex++, l++);
            }else if(arr[l] > num){
                swap(arr, l, --r);
            }else{
                l++;
            }
        }
    }

    public void swap(int[] arr, int index1, int index2){
        int x = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = x;
    }
}
