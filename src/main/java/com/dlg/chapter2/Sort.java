package com.dlg.chapter2;

public class Sort {

    // 1、经典快排：递归版
    // 每次递归只确定一个数的位置
    // 每次递归对数组进行一次划分，并返回划分后的前后位置，根据划分后的位置再递归的划分。每次用于划分的数都是划分段上的最后一个数
    // 起始划分包含数组的第一和最后一个位置
    public void quickSort(int[] arr, int num, int l, int r){

        if(l >= r)
            return;

        int[] result = partion3(arr, num, l, r);

        if(result[0] >= 0 && result[1] >= 0) {
            quickSort(arr, arr[result[0]], l, result[0]);
            quickSort(arr, arr[r], result[1], arr.length - 1);
        }

    }

    public void quickSort2(int[] arr, int num, int l, int r){

        if(l >= r)
            return;

        int[] result = partion4(arr, num, l, r);

        if(result[0] >= 0) {// 区别
            quickSort2(arr, arr[result[0]], l, result[0]);
        }
        quickSort2(arr, arr[r], result[1], arr.length - 1);

    }

    // 数组划分
    public void partion(int[] arr, int num){

        int l = 0;
        int r = arr.length;

        while(l < r){
            if(arr[l] > num){
                swap(arr, l, --r);// 交换，并扩大大于区域
            }else{
                l++;
            }
        }

    }

    // 数组划分
    public int[] partion2(int[] arr, int num, int l, int r){

        while(l < r){
            if(arr[l] > num){
                swap(arr, l, --r);// 交换，并扩大大于区域
            }else{
                l++;
            }
        }

        return new int[]{l - 1, r};

    }

    // 数组划分
    public int[] partion3(int[] arr, int num, int l, int r){

        while(l < r){
            if(arr[l] > num){
                swap(arr, l, r--);// 交换，并扩大大于区域
            }else{
                l++;
            }
        }

        return new int[]{l - 1, r};

    }

    // 数组划分改进，将相等的放到中间，减少划分次数
    public int[] partion4(int[] arr, int num, int l, int r){

        int less = l;

        while(l <= r){ // 区别
            if(arr[l] > num){
                swap(arr, l, r--);// 交换，并扩大大于区域
            }else if(arr[l] == num){
                l++;
            }else{// 区别
                swap(arr, less++, l++);
            }
        }

        return new int[]{less - 1, r};// 区别

    }

    private void swap(int[] arr, int l, int r) {

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

    }

}
