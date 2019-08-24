package com.dlg.chapter1;

import org.junit.Test;

public class QuestionTest {

    // 求数组小和
    @Test
    public void xiaohe(){

        int[] arr = new int[]{7, 4, 1, 3, 5};

        Question q = new Question();
        q.mergeSort(arr, 0, 4);
        System.out.println("result: " + q.result);
    }

    // 求逆序对
    @Test
    public void reverse(){

        int[] arr = new int[]{7, 4, 1, 3, 5};

        Question q = new Question();
        q.mergeSort2(arr, 0, 4);
        System.out.println("result: " + q.reverse);

        for(int[] x : q.reverse){
            System.out.println(x[0] + "," + x[1]);
        }
    }
}
