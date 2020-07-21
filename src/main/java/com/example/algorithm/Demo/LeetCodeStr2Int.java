package com.example.algorithm.Demo;

/**
 * 剑指offer 将一个字符串转换成一个Int类型
 * 不能使用java中的函数库
 */
public class LeetCodeStr2Int {
    public static void main(String[] args) {
        System.out.println(StrToInt("-11sa11"));
    }

    public static int StrToInt(String str) {
        char[] cs = str.toCharArray();
        int sum = 0;
        int startIndex = 0;
        boolean isCompareZero = true;
        if (cs[0] == '-'){
            isCompareZero = false;
            startIndex = 1;
        }
        if (cs[0] == '+'){
            startIndex = 1;
        }
        for (int i = startIndex;i<cs.length; i ++){
            if(cs[i] >= 48 && cs[i] <= 57){
                sum = sum * 10 + cs[i] - 48;
            }else{
                return 0;
            }
        }
        return isCompareZero ? sum : -sum;
    }
}
