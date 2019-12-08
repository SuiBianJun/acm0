package com.dlg.chapter3;

import org.junit.Test;

public class Question2Test {

    @Test
    public void myStackTest(){

        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.pop();
        stack.push(2);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

    }

    // shift + f5 选中同名变量
    @Test
    public void myQueueTest(){

        MyQueen<Integer> queen = new MyQueen<>();

        queen.push(1);
        queen.push(1);
        queen.push(1);
        queen.push(1);
        queen.push(1);
        queen.push(1);
        queen.pop();
        queen.push(2);
        queen.pop();
        queen.pop();
        queen.pop();
        queen.pop();
        queen.pop();
        queen.pop();

    }

    @Test
    public void myStack2Test(){

        MyStack2 stack = new MyStack2();

        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(1);
        stack.push(1);
        stack.pop();
        stack.push(0);

    }

    @Test
    public void queueByStackTest(){

        QueenByStack queen = new QueenByStack();

        queen.push(1);
        queen.push(2);
        queen.push(3);
        queen.pop();
        queen.push(4);
        queen.pop();
        queen.push(5);
        queen.push(6);
        queen.pop();
        queen.pop();
        queen.push(2);
        queen.pop();
        queen.pop();
        queen.pop();

    }

    @Test
    public void StackByQueenTest(){

        StackByQueen stack = new StackByQueen();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.push(4);
        stack.pop();
        stack.push(5);
        stack.push(6);
        stack.pop();
        stack.pop();
        stack.push(2);
        stack.pop();
        stack.pop();
        stack.pop();

    }

}
