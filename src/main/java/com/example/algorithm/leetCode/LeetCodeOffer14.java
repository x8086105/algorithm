package com.example.algorithm.leetCode;

public class LeetCodeOffer14 {
    public static void main(String[] args) {
       int s = cuttingRope(2);
        System.out.println(s);
    }

    public static int cuttingRope(int n) {
        //根据数学定义，乘积最大的就是两个数最接近的
        //分成m段

        int pre = 1;
        for (int i = 2;i<n;i++){
            if(pre > getSum(n,i)){
                return pre;
            }
            pre =  getSum(n,i);
        }

        return pre;
    }

    private static int getSum(int n, int m) {
        int sum = 1;
        for(int i = m;i > 0; i-- ){
            int c = n/i;
            sum *= c;
            n = n - c;
        }
        return sum;
    }
}
