package com.dlg.chapter2;

import com.dlg.utils.ArrayUtil;

public class Sort2 {

    // 堆排序
    // 堆排序 = 建立大（小）根堆 + 弹出堆顶 + 调整堆结构

    public void heapSort(int arr[]){

        createBigHeap(arr);

        for(int i = arr.length - 1; i > 0; i--){
            heapfiyBigHeap(arr, i);
        }

    }

    // 创建大根堆, 将一个数组调整为大根堆结构
    public int[] createBigHeap(int[] arr){

        int currentIndex = 0;

        for(int i = 0; i < arr.length; i++){
            currentIndex = i;
            while(currentIndex > 0){
                if(arr[(currentIndex - 1) / 2] < arr[currentIndex]){
                    ArrayUtil.swap(arr, (currentIndex - 1) / 2, currentIndex);
                    currentIndex = (currentIndex - 1) / 2;
                }else{
                    break;// 注意死循环
                }
            }
        }

        return arr;
    }

    // 弹出堆 堆顶 的元素后，重新调整为对应的堆结构
    // 弹出的元素可以直接和数组的最后一个元素交换，然后再调整堆结构
    public void heapfiyBigHeap(int[] arr, int size){

        ArrayUtil.swap(arr, 0, size);

        int s = 0;
        int temp = 0;

        while(s < size){
            temp = heapfiyBigSwap(s, s * 2 + 1, s * 2 + 2, size, arr);
            if(s != temp){
                s = temp;// 下沉
            }else{// 不用下沉时，调整完成
                break;
            }
        }
    }

    // 大根堆 调整
    public int heapfiyBigSwap(int root, int l, int r, int size, int[] arr){

        int maxIndex = root;
        int tempIndex = l;

        if(r < size){
            // 有左右节点
            tempIndex = arr[l] > arr[r] ? l : r;

            maxIndex = arr[root] > arr[tempIndex] ? maxIndex : tempIndex;

        }else if(l < size){
            // 只有左节点
            maxIndex = arr[root] > arr[l] ? maxIndex : l;
        }

        if(maxIndex != root){
            // 元素下沉
            ArrayUtil.swap(arr, root, maxIndex);
        }

        return maxIndex;

    }

}
