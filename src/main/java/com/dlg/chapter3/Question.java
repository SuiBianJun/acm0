package com.dlg.chapter3;

import com.dlg.utils.ArrayUtil;

public class Question {

    /*
    *
    * 1、不能使用基于非比较的排序方法，求一个数组在排序后最大的相邻两数之间的间隔。时间复杂度O(N)
    *
    * a、可排序后再计算，但时间复杂度不符合要求
    *
    * b、借用桶排序的想法
    *   1、使用N + 1一个桶，将最小值和最大值分别放入第一个和最后一个桶中。
    *   2、将剩下的数 等比例 放入对应的桶中，在但每个桶只用存放进入该桶的最大与最小值。
    *   3、由于第一步设置了N + 1个桶，因此必将存在空桶。因此，排序之后最大间隔不会 存在于桶内，只会存在于桶与桶之间
    *   4、遍历所有桶，获取最大间隔
    * */

    public int getMaxGap(int[] arr){

        if(arr.length == 0){
            return 0;
        }

        int min = arr[0];
        int max = arr[0];

        for(int i = 0; i < arr.length; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        if(min == max)
            return 0;

        boolean[] hasNum = new boolean[arr.length + 1];
        int[] minArr = new int[arr.length + 1];
        int[] maxArr = new int[arr.length + 1];


        hasNum[0] = true;
        hasNum[arr.length] = true;
        minArr[0] = maxArr[0] = min;
        maxArr[arr.length] = minArr[arr.length] = max;

        for(int i = 0; i < arr.length; i++){
            int bucket = getBucket(arr[i], min, max, arr.length);
            minArr[bucket] = hasNum[bucket] ? Math.min(minArr[bucket], arr[i]) : arr[i];
            maxArr[bucket] = hasNum[bucket] ? Math.max(maxArr[bucket], arr[i]) : arr[i];
            hasNum[bucket] = true;
        }

        ArrayUtil.printArr(minArr, "x");
        ArrayUtil.printArr(maxArr, "x");

        int result = 0;
        int index = 0;
        for(int i = 1; i < arr.length + 1; i++){
            if(hasNum[i]){
                result = Math.max(minArr[i] - maxArr[index], result);
                index = i;
            }
        }

        System.out.println("max gap: " + result);

        return 0;

    }

    public int getBucket(int v, int min, int max, int length){

        int x = (int) Math.ceil((float)(max - min) / (length + 1));

        return ( v ) / ( x );

    }

    public static void main(String[] args){

        System.out.println(Math.ceil((float) 1 / 2));
    }

}
