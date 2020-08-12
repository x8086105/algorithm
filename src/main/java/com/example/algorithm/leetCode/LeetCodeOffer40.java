package com.example.algorithm.leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCodeOffer40 {

    public static void main(String[] args) {
        int []arr= {3,2,1};
        int k = 2;
        int []result = getLeastNumbers2(arr,k);
        System.out.println(result);
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        int []result = new int[k];
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        for(int i = 0;i<arr.length;i++){
            if(queue.size() < k){
                queue.add(arr[i]);
            }else if(queue.peek() > arr[i]){
                queue.poll();
                queue.add(arr[i]);
            }
        }
        for(int i = 0;i<k;i++){
            result[i] = queue.poll();
        }
        return result;
    }

    /**
     * 采用计数排序，范围有限的话，可以这么用
     * 最大最小都可以用，还贼简单的那种 for循环的起始位置即可
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers2(int[] arr, int k) {
        int []counter = new int[10001];
        for(int index : arr){
            counter[index]++;
        }
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && idx < k) {
                res[idx++] = num;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }
}
