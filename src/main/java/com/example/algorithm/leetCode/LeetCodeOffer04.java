package com.example.algorithm.leetCode;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输
 * 入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 解释： 从右上角和左下角进行查找
 *
 */
public class LeetCodeOffer04 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
       boolean result = findNumberIn2DArray(matrix,77);
        System.out.println(result);
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //n代表行 m代表列
        int n = matrix.length;
        if(n == 0){
            return false;
        }
        int m = matrix[0].length;
        if(m == 0){
            return false;
        }
        for(int i = 0, j = m - 1; j >= 0 && i < n;){
            if(matrix[i][j] == target){
                return true;
            }
            if(matrix[i][j] < target){
                if (j < m -1){
                    j++;
                }
                i++;
                continue;
            }
            j--;
        }
        return false;
    }
}
