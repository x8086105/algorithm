package com.example.algorithm.leetCode;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 */
public class LeetCodeOffer09 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> exchangeStack = new Stack<>();

    public void appendTail(int value) {
        if(stack.size() == 0 ){
            stack.push(value);
            return;
        }
        //将stack数据放到exchangeStack中
        while (stack.size() > 0){
            exchangeStack.push(stack.pop());
        }
        exchangeStack.push(value);
        while (exchangeStack.size() > 0){
            stack.push(exchangeStack.pop());
        }
    }

    public int deleteHead() {
        if(stack.size() == 0){
            return -1;
        }
        return stack.pop();
    }
}
