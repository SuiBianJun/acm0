package com.dlg.chapter3;

import org.junit.Test;

public class QuestionTest {

    int arr[] = {1, 2, 14, 7, 1, 2, 8, 14, 15, 3, 4, 5, 6, 20};

    @Test
    public void getMaxGapTest(){
        new Question().getMaxGap(arr);
    }

}
