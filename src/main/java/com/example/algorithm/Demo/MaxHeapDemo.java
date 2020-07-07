package com.example.algorithm.Demo;

import com.example.algorithm.dataStructure.MaxHeap;

import java.util.Random;

/**
 * 测试堆元素
 */
public class MaxHeapDemo {

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        int [] s = {62,52,30,28,41,22,13,19,17,15,16};
        for(int i = 0;i<s.length;i++){
            maxHeap.add(s[i]);
        }
        int max = maxHeap.extractMax();
        System.out.println(maxHeap);

        //存储100W个随机数，然后分别拿出最大值放在堆中
        int n = 1000000;
        MaxHeap<Integer> maxHeap1 = new MaxHeap<>();
        Random random = new Random();
        for(int i = 0;i<n;i++){
            maxHeap1.add(random.nextInt(Integer.MAX_VALUE));
        }
        int []arr =new int[n];
        for(int i = 0;i<n;i++){
            arr[i]= maxHeap1.extractMax();
        }
        for(int i = 1;i<n;i++){
            if(arr[i-1]<arr[i]){
                throw new IllegalArgumentException("Exception");
            }
        }
        System.out.println("MaxHeap is Completed");
        System.out.println("-------开始测试两者添加元素的时间---------");

        Integer[] numbers = new Integer[n];
        for(int i = 0;i<n;i++){
            numbers[i] = random.nextInt(Integer.MAX_VALUE);
        }
        Long startTime1 = System.currentTimeMillis();
        MaxHeap<Integer> maxHeap2 = new MaxHeap<>(numbers);
        System.out.println("heapify添加元素的时间为：" + (System.currentTimeMillis() - startTime1));
        Long startTime2 = System.currentTimeMillis();
        MaxHeap<Integer> maxHeap3 = new MaxHeap<>();
        for(int i = 0;i<n;i++){

            maxHeap3.add(numbers[i]);
        }
        System.out.println("非heapify添加元素的时间为：" + (System.currentTimeMillis() - startTime2));

    }
}
