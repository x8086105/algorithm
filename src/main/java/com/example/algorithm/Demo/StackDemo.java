package com.example.algorithm.Demo;

import com.example.algorithm.dataStructure.ArrayStack;

public class StackDemo {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for(int i = 0;i<10;i++){
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.peek();
        System.out.println(stack);
    }

}
