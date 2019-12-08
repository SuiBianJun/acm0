package com.dlg.chapter3;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Question2 {





}
// 1、使用数组实现 固定大小的栈
/*
*
* 实现：
*   用index变量指示当前入栈的位置，起始位置index=0
*   1、入栈时，当index大于栈大小，抛异常
*   2、出栈时，当index小于0时，抛异常
*
* */
class MyStack<T>{

    int size;// 栈 大小
    Object [] data = null;
    int index = 0;

    public MyStack(int size){
        this.size = size;
        data = new Object[size];
    }
    public MyStack(){
        this(5);// 默认大小
    }

    public T push(T t){// 压栈

        if(index >= size){
            try {
                throw new Exception("栈已满");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            data[index++] = t;
        }
        return t;
    }

    public T pop(){
        if(index <= 0){
            try {
                throw new Exception("栈已空");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (T) data[--index];
    }

    public T peek(){
        if(index < 0){
            try {
                throw new Exception("栈已空");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (T) data[index - 1];
    }
    public int size(){
        return index <= 0 ? 0 : index;
    }

    public void printStackStatus(){
        System.out.println("");
    }
}

// 2、使用数组实现 固定大小的队列
/*
 *
 * 实现：
 *      1、使用一个中间变量length和进队列标识end、出栈标识start，简化操作
 *      2、end指示当前入队列位置，成功入栈length+1，当length大于size时，抛异常
 *      3、start指示当前出队列位置，成功出队列length-1，当length小于0时，抛异常
 * */

class MyQueen<T>{

    int size;
    Object data [];

    int length = 0;
    int start = 0;
    int end = 0;

    public MyQueen(int size) {
        this.size = size;
        data = new Object[size];
    }
    public MyQueen() {
        this(5);
    }
    public T push(T t){
        if(this.length >= size){
            try {
                throw new Exception("队列已满");
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        this.length++;
        data[end++] = t;
        end = end >= size ? 0 : end;
        return t;
    }

    public T pop(){
        if(this.length <= 0){
            try {
                throw new Exception("队列已空");
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        this.length--;
        T t = (T) data[start++];
        start = start >= size ? 0 : start;
        return t;
    }

    public int size(){
        return this.length;
    }
}

// 3、设计算法实现栈的push、pop、和getMin() 操作的时间复杂度都为 O(1)
/*
*   双栈方式:
*       1、栈A记录栈原始数据，栈B记录栈最小值数据
*       2、栈A进栈时，如果栈B为空，数据直接进栈B，否则与B栈顶元素比较，较小值进栈B
* */
class MyStack2 {

    MyStack<Integer> stack = new MyStack<>();
    MyStack<Integer> minStack = new MyStack<>();

    public void push(Integer data){
        stack.push(data);
        minStack.push(minStack.size() == 0 ? data : Math.min(data, minStack.peek()));
    }

    public Integer pop(){
        minStack.pop();
        return stack.pop();
    }

    public Integer getMin(){
        return minStack.peek();
    }
}

// 4、使用栈结构实现队列
/*
*
*   双栈结构实现队列：
*       1、栈A用于队列进，栈B用于队列出
*       2、当入队列时，直接进栈A
*       3、出队列时，如果栈B为空，则先将栈A元素全部弹出到栈B，然后栈B再把栈顶元素弹出。如果栈B不为空，直接弹出栈B栈顶元素。
*
* */
class QueenByStack{

    MyStack<Integer> stackA = new MyStack<>();
    MyStack<Integer> stackB = new MyStack<>();

    public void push(Integer data){
        stackA.push(data);
    }

    public Integer pop(){
        if(stackB.size() == 0){
            while(stackA.size() != 0){
                stackB.push(stackA.pop());
                MyStack<Integer> tempStack = new MyStack<>();
                tempStack = stackA;
                stackA = stackB;
                stackB = tempStack;// 保持B为空栈，栈A为原始栈，否者队列大小需要另外判断（两个栈大小之和）
            }
        }
        return stackB.pop();
    }
}

// 5、使用队列实现栈
/*
*
*   双队列实现栈：
*       1、队列A用于进栈
*       2、出栈时，如果队列A有元素，则队列A出队列直到队列只剩一个元素，返回该元素
*       3、出栈后，如果队列B剩余有元素，则将队列B的元素出队列到队列A
*
*
* */
class StackByQueen{

    MyQueen<Integer> queenA = new MyQueen<>();
    MyQueen<Integer> queenB = new MyQueen<>();

    public void push(Integer data){
        queenA.push(data);
    }

    public Integer pop(){

        if(queenA.size() == 0){// queenA 为空
            if(queenB.size() == 0){// 此时无元素
                try {
                    throw new Exception("栈为空");
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0;
                }
            }else{//
                while(queenB.size() > 1){
                    queenA.push(queenB.pop());
                }
                MyQueen<Integer> tempQueen = new MyQueen<>();
                tempQueen = queenA;
                queenA = queenB;
                queenB = tempQueen;

                return queenB.pop();
            }
        }else{
            while(queenA.size() > 1){
                queenB.push(queenA.pop());
            }
            return queenA.pop();
        }
    }

}