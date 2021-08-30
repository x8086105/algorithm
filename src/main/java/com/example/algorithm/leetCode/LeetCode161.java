package com.example.algorithm.leetCode;

public class LeetCode161 {
    public static boolean isOneEditDistance(String s, String t) {
        //return solution1();
        return solution2(s,t);
    }

    public static boolean solution2(String s, String t) {
        //return solution1();
        int ns = s.length();
        int ts = t.length();

        if(s.equals(t)){
            return false;
        }
        //始终保持前面字符串的长度小于后面字符串的长度
        if(ns > ts){
            return solution2(t,s);
        }
        //如果长度不相等的话，相差不能超过1
        if(ts - ns > 1){
            return false;
        }
        for(int i = 0; i < ns; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(ns == ts){
                    //长度相等的话 这里是直接截取，判断后面那一长串是否相等
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }else{
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return true;
    }
    //下面这个解法啰里啰嗦的。垃圾的一批

    private static boolean solution1(String s,String t){
        if(s.equals(t)){
            return false;
        }
        int sLength = s.length();
        int tLength = t.length();
        //相等的时候，应该只有一个字符对不上才对
        if(sLength == tLength){
            boolean flag = false;
            for(int i = 0;i < sLength; i++){
                if(s.charAt(i) != t.charAt(i)){
                    if(!flag){
                        flag= true;
                    }else{
                        return false;
                    }
                }
            }
            return true;
        }else{
            int ss = Math.abs(sLength - tLength);
            if(ss != 1){
                return false;
            }
            boolean inc = sLength > tLength;
            boolean flag = false;
            int i = 0, j =0;
            while(i < sLength && j < tLength){
                if(s.charAt(i) != t.charAt(j)){
                    if(inc){
                        i++;
                    }else{
                        j++;
                    }
                    if(!flag){
                        flag = true;
                    }else{
                        return false;
                    }
                }else{
                    i++;
                    j++;
                }
            }
            return true;

        }
    }

    public static void main(String[] args) {
        boolean s = isOneEditDistance("abcd","accc");
        System.out.println(s);
    }

}
