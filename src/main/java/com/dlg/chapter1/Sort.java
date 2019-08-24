package com.dlg.chapter1;

public class Sort {

    // 冒泡排序 O(n^2)
    public int[] bibulSort(int arr[]){

        for(int i = arr.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j + 1]){
                    exchangeData(arr, j, j + 1);
                }
            }
        }

        return arr;
    }

    // 选择排序 O(n^2)
    // 每次选择一个目标值到 头部或者尾部
    public int[] selectSort(int arr[]){
        int index = 0;
        for(int i = arr.length - 1; i > 0; i--){
            index = i;
            for(int j = 0; j <= i; j++){
                if(arr[j] > arr[index]){
                    index = j;
                }
            }
            exchangeData(arr, i, index);
        }

        return arr;
    }

    // 插入排序
    public int[] insertSort(int arr[]){

        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j - 1]){
                    exchangeData(arr, j, j - 1);
                }
            }
        }

        return arr;
    }

    // 交换数组两个位置的数据
    public void exchangeData(int arr[], int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


    // 归并排序
    public void mergeSort(int arr[], int L, int R){

        if(L == R)
            return;

        int mid = (L + R) / 2;
        mergeSort(arr, 0, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);

    }

    // 有序数组合并
    public void merge(int[] arr, int L, int mid, int R) {

        int P = mid + 1;
        int[] t = new int[R - L + 1];
        int index = 0;
        int l = L;
        int r = R;
        while (L <= mid && P <= R) {
            if (arr[L] < arr[P]) {
                t[index++] = arr[L];
                L++;
            } else {
                t[index++] = arr[P];
                P++;
            }
        }
        if(L > mid){
            while(P <= R){
                t[index] = arr[P];
                index++;
                P++;
            }
        }
        if(P > R){
            while(L <= mid){
                t[index] = arr[L];
                index++;
                L++;
            }
        }
        index = 0;
        for(int i = l; i <= r; i++){
            arr[i] = t[index++];
        }
    }
}
