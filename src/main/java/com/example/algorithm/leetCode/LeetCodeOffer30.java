package com.example.algorithm.leetCode;


import java.util.Stack;

/**
 * 最小栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class LeetCodeOffer30 {
    public static void main(String[] args) {
        MinStack stack = new MinStack();

    }
}

class MinStack {
    //首先，定义两个栈， 首先分析这个问题，栈本身的push和 pop以及top都是O(1)的时间复杂度
    // 这里要做的就是拿到min方法的时候 也要是O(1)的时间复杂度
    // 一个是用来存储所有的数据的，另一个用来存储非严格降序的栈
    private Stack<Integer> stackA;
    private Stack<Integer> stackB;
    /** initialize your data structure here. */
    public MinStack() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {
        stackA.push(x);

        //判断加入到栈B是否加入
        if (stackB.empty() || stackB.peek() > x){
            stackB.push(x);
        }
    }

    public void pop() {
        if(! stackA.isEmpty()){
            int popE = stackA.pop();
            if(! stackB.empty() && stackB.peek() == popE){
                stackB.pop();
            }
        }
    }

    public int top() {
        if (stackA.isEmpty()){
            return -1;
        }
        return stackA.peek();
    }

    public int min() {
        if (stackB.isEmpty()){
            return -1;
        }
        return stackB.peek();
    }
}
