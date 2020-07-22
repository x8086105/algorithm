package com.example.algorithm.leetCode;

/**
 *地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 输入 m = 2, n = 3, k = 1
 * 输出：3
 *
 *
 */
public class LeetCodeOffer13 {
    public static void main(String[] args) {
        //字符串对应的坐标以及状态

        System.out.println(movingCount(2,3,1));
    }

    public static int movingCount(int m, int n, int k) {

        int movingCount = 1;
        boolean [][] isVisitor = new boolean[m][n];
        return movingCount(0,0,k,isVisitor,0);
    }

    private static int movingCount(int i, int j, int k,boolean [][] isVisitor,int index) {
        int m = isVisitor.length;
        int n = isVisitor[0].length;
        if(i < 0 || j < 0 || i > m || j > n || (i /10 + i%10 + j/10 + j%10) > k ||isVisitor[i][j]){
            return 0;
        }
        isVisitor[i][j] = true;
        int supCount = movingCount(i - 1,j,k , isVisitor,index + 1);
        int downCount = movingCount(i + 1,j,k ,isVisitor,index + 1);
        int leftCount = movingCount(i ,j - 1,k,isVisitor,index + 1);
        int rightCount = movingCount(i ,j + 1,k,isVisitor,index + 1);
        isVisitor[i][j] = false;

        return supCount + downCount + leftCount + rightCount + 1;
    }


}
