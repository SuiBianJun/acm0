package com.dlg.chapter2;

import com.dlg.utils.ArrayUtil;
import org.junit.Test;

public class Sort2Test {

    int arr[] = new int[]{4, 3, 1, 5, 7, 2, 0};

    @Test
    public void heapSortTest(){
        new Sort2().heapSort(arr);
        ArrayUtil.printArr(arr);
    }

}
