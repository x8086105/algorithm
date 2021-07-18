package com.example.algorithm.leetCode;

public class LeetCode415 {

    public static void main(String[] args) {
        System.out.println(addStrings("1","9"));
    }

    //这个类似大数相加
    public static String addStrings(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int i = length1 - 1;
        int j = length2 - 1;
        //需要往前进位
        int cur = 0;
        String result = "";
        while(i >= 0 || j >= 0){
            int k1 = 0,k2 = 0;
            if(i >= 0){
                k1 = Integer.parseInt(num1.charAt(i)+"");
                i--;
            }
            if(j >= 0){
                k2 = Integer.parseInt(num2.charAt(j)+"");
                j--;
            }
            //当前总数和位
            int c = k1 + k2 + cur;
            cur = c / 10;
            int v = c % 10;
            //v其实就是真实的值
            result = v + result;
        }
        if(cur!=0){
            result = cur + result;
        }
        return result;
    }
}
