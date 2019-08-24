package com.dlg.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Question {

    // 1、求无序数组中的小和
    // 小和：左边小于等于右边的所有和

    int result = 0;

    public void mergeSort(int arr[], int L, int R){

        if(L == R)
            return;

        int mid = (L + R) / 2;

        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        result += merge(arr, L, mid, R);

    }

    public int merge(int arr[], int L, int mid, int R){

        int r = mid + 1;
        int l = L;
        int index = 0;
        int[] temp = new int[R - L + 1];
        int result = 0;

        while(l <= mid && r <= R){

            if(arr[l] <= arr[r]){
              // 产生小和
              result += (R - r + 1) * arr[l];// 批量求小和
              temp[index++] = arr[l++];
            }else{
                temp[index++] = arr[r++];
            }

        }

        if(l > mid){
            while(r <= R){
                temp[index++] = arr[r++];
            }
        }
        if(r > R){
            while(l <= mid){
                temp[index++] = arr[l++];
            }
        }
        index = 0;
        for(int i = L; i <= R; i++){
            arr[i] = temp[index++];
        }

        return result;
    }

    // 2、求数组中的所有逆序对（左边大于右边的数对）
    // 和求小和一个原理

    List<int[]> reverse = new ArrayList<>();

    public void mergeSort2(int arr[], int L, int R){

        if(L == R)
            return;

        int mid = (L + R) / 2;

        mergeSort2(arr, L, mid);
        mergeSort2(arr, mid + 1, R);
        merge2(arr, L, mid, R);

    }

    public void merge2(int arr[], int L, int mid, int R){

        int r = mid + 1;
        int l = L;
        int index = 0;
        int[] temp = new int[R - L + 1];

        int currentIndex = 0;

        while(l <= mid && r <= R){

            if(arr[l] <= arr[r]){
                temp[index++] = arr[l++];
            }else{
                // 产生逆序对， l -> mid

                currentIndex = l;
                while(currentIndex <= mid){
                    reverse.add(new int[]{arr[currentIndex++], arr[r]});
                }

                temp[index++] = arr[r++];

            }

        }

        if(l > mid){
            while(r <= R){
                temp[index++] = arr[r++];
            }
        }
        if(r > R){
            while(l <= mid){
                temp[index++] = arr[l++];
            }
        }
        index = 0;
        for(int i = L; i <= R; i++){
            arr[i] = temp[index++];
        }

    }

}
