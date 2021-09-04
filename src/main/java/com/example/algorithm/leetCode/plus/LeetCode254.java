package com.example.algorithm.leetCode.plus;

import java.util.ArrayList;
import java.util.List;

/**
 * 254. 因子的组合
 * 整数可以被看作是其因子的乘积。
 *
 * 例如：
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。
 *
 * 注意：
 *
 * 你可以假定 n 为永远为正数。
 * 因子必须大于 1 并且小于 n。
 * 示例 1：
 *
 * 输入: 1
 * 输出: []
 * 示例 2：
 *
 * 输入: 37
 * 输出: []
 * 示例 3：
 *
 * 输入: 12
 * 输出:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 * 示例 4:
 *
 * 输入: 32
 * 输出:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 */
public class LeetCode254 {
    public List<List<Integer>> getFactors(int n) {
        return dfs(2,n);
    }

    List<List<Integer>> dfs(int start, int num) {
        if (num == 1) {
            return new ArrayList<>();
        }
        int qNum = (int)Math.sqrt(num);
        List<List<Integer>> result = new ArrayList<>();
        for (int mulNum = start; mulNum <= qNum;mulNum++) {
            if (num % mulNum == 0) {
                List<Integer> simpleList = new ArrayList<>();
                simpleList.add(mulNum);
                simpleList.add(num/mulNum);
                result.add(simpleList);
                // 检查mulNum能怎么拆
                List<List<Integer>> nextLists = dfs(mulNum, num/mulNum);
                for (List<Integer> list : nextLists) {
                    list.add(mulNum);
                    result.add(list);
                }
            }
        }
        return result;
    }
}

