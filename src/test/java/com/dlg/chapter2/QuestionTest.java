package com.dlg.chapter2;

import org.junit.Test;

public class QuestionTest {


    int arr[] = new int[]{4, 3, 1, 5, 7, 2};

    int arr2[] = new int[]{4, 3, 1, 5, 3, 3, 3, 7, 2, 3};

    // 数组划分
    @Test
    public void partionArrTest(){
        Question q = new Question();

        q.partionArr(arr, 3);

        printArr(arr);
    }

    // 数组划分-2
    @Test
    public void partionArr2Test(){
        Question q = new Question();

        q.partionArr2(arr2, 3);

        printArr(arr2);
    }

    public void printArr(int arr[]){
        for(int x : arr){
            System.out.print(x + " ");
        }
    }

}
