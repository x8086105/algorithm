package com.example.algorithm.leetCode;

import java.util.HashMap;

/**
 * 斐波那契队列
 */
public class LeetCodeOffer10_1 {

    public static void main(String[] args) {
        System.out.println(fib1(48));
    }
    /**
     * 使用递归解决
     * 使用Map 记录已经存在的记录
     * @param n
     * @return
     */
    public static int fib1(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        return fib3(n ,map);
    }

    /**
     *
     //使用一个字典记录当前这个值已经被计算过了没有
     * @param n
     * @param map
     * @return
     */
    private static int fib3(Integer n, HashMap<Integer,Integer> map){
        if(map.get(n) != null){
            return map.get(n);
        }
        int result =  fib3(n - 1,map) + fib3(n - 2,map);
        result %= 1000000007;
        map.put(n, result);
        return result;
    }

    /**
     * 使用迭代解决
     * @param n
     * @return
     */
    public static int fib2(int n){
        if(n == 0 || n == 1){
            return n;
        }
        if(n == 2){
            return 1;
        }
        int first = 0;
        int second = 1;
        int result = 0;
        for (int i = 2; i <= n; i++)
        {
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }
}
