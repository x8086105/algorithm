package com.example.algorithm.leetCode;

import java.util.Stack;

public class LeetCodeOffer31 {

    public static void main(String[] args) {
        int [] pushed = {1,2}, popped = {1,2};
        boolean validateStackSequences = validateStackSequences(pushed,popped);
        System.out.println(validateStackSequences);
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        //遍历popped 取不出来的话 就压入这个栈，直到所有数都压入成功了 还是取不出来 就代表输出顺序不行哦
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
