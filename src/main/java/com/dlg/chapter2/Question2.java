package com.dlg.chapter2;

import com.dlg.utils.ArrayUtil;

import java.util.Random;

public class Question2 {

    /*
    *  堆结构的生成
    *   堆结构类似于 满二叉树 和 完全二叉树结构
    *
    * */
    // 1、大根堆
    // 每棵子树的父节点都比子节点的值大
    /*
    *               10
    *              /  \
    *             6    7
    *            / \  / \
    *           5   1 2  6
    *
    * */

    // 创建大根堆, 将一个数组调整为大根堆结构
    public void createBigHeap(int[] arr){

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
    }

    // 创建大根堆, 将一个数组调整为大根堆结构
    public void createBigHeap(int[] arr, int size){

        int currentIndex = 0;

        for(int i = 0; i < size; i++){
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
    }

    // 创建小根堆, 将一个数组调整为小根堆结构
    public void createTinyHeap(int[] arr){

        int currentIndex = 0;

        for(int i = 0; i < arr.length; i++){
            currentIndex = i;
            while(currentIndex > 0){
                if(arr[(currentIndex - 1) / 2] > arr[currentIndex]){
                    ArrayUtil.swap(arr, (currentIndex - 1) / 2, currentIndex);
                    currentIndex = (currentIndex - 1) / 2;
                }else{
                    break;// 注意死循环
                }
            }
        }
    }

    // 创建小根堆, 将一个数组调整为小根堆结构
    public void createTinyHeap(int[] arr, int size){

        int currentIndex = 0;

        for(int i = 0; i < size; i++){
            currentIndex = i;
            while(currentIndex > 0){
                if(arr[(currentIndex - 1) / 2] > arr[currentIndex]){
                    ArrayUtil.swap(arr, (currentIndex - 1) / 2, currentIndex);
                    currentIndex = (currentIndex - 1) / 2;
                }else{
                    break;// 注意死循环
                }
            }
        }
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

    public void heapfiyTinyHeap(int[] arr, int size){

        ArrayUtil.swap(arr, 0, size);

        int s = 0;
        int temp = 0;

        while(s < size){
            temp = heapfiyTinySwap(s, s * 2 + 1, s * 2 + 2, size, arr);
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

    // 大根堆 调整
    public int heapfiyTinySwap(int root, int l, int r, int size, int[] arr){

        int tinyIndex = root;
        int tempIndex = l;

        if(r < size){
            // 有左右节点
            tempIndex = arr[l] < arr[r] ? l : r;

            tinyIndex = arr[root] < arr[tempIndex] ? tinyIndex : tempIndex;

        }else if(l < size){
            // 只有左节点
            tinyIndex = arr[root] < arr[l] ? tinyIndex : l;
        }

        if(tinyIndex != root){
            // 元素下沉
            ArrayUtil.swap(arr, root, tinyIndex);
        }

        return tinyIndex;

    }

    // 问题：求中位数问题
    // 在任意时刻求一个数字发生器产生的所有数字的中位数
    // 解法：使用大小根堆存储产生的数字，中位数即堆顶的数字之间的操作
    /*
    *  时间复杂度：
    *   T = T（加入堆中的操作） + T（调整堆的操作）+ T(取出中位数) = logN
    *   1、对于往已经形成大（小）堆结构的堆中加入元素再形成大（小）根堆得时间复杂度为logN
    *   2、调整堆结构时间复杂度为logN
    *   3、取出中位数时间复杂度O（1）
    *
    *
    * */
    public void getMiddle(){

        int length = new Random().nextInt(10) + 10;

        int[] big = new int[20];// 长度不定时，使用动态结构（列表等）代替
        int bigSize = 0;
        int[] tiny = new int[20];
        int tinySize = 0;

        int num = 0;

        for(int i = 0; i < length; i++){
            num = new Random().nextInt(20);;
            if(num <= big[bigSize]){
                big[bigSize++] = num;
                createBigHeap(big, bigSize);

                if(Math.abs(bigSize - tinySize) > 1){// 平衡堆中 数的 数量
                    tiny[tinySize++] = big[0];// 弹出到小根堆
                    createTinyHeap(tiny, tinySize);// 重建堆

                    heapfiyBigHeap(big, bigSize - 1);// 调整堆
                    big[bigSize - 1] = 0;
                    bigSize--;
                }


            }else{
                tiny[tinySize++] = num;
                createTinyHeap(tiny, tinySize);
                if(Math.abs(bigSize - tinySize) > 1){// 平衡堆中 数的 数量
                    big[bigSize++] = tiny[0];// 弹出到大根堆
                    createBigHeap(big, bigSize);// 重建堆

                    heapfiyTinyHeap(tiny, tinySize - 1);// 调整堆
                    tiny[tinySize - 1] = 0;
                    tinySize--;
                }
            }
        }

        System.out.println("bigSize: " + bigSize);
        System.out.println("tinySize: " + tinySize);

        ArrayUtil.printArr(big, 0, bigSize);
        ArrayUtil.printArr(tiny, 0, tinySize);

        int middle = bigSize == tinySize ? (big[0] + tiny[0]) / 2 : bigSize > tinySize ? big[0] : tiny[0];
        System.out.println("middle = " + middle);

    }
}
