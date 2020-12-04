package com.example.algorithm.leetCode;

import com.example.algorithm.sourceCode.HashMapSourceTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 */

public class LeetCode204 {

    public static void main(String[] args) {
        int c = countPrimes(12);
        System.out.println(c);
    }

    /**
     * 暴力解法，经常超时
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            //判断当前是否是质数
            boolean flags = false;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flags = true;
                    break;
                }
            }
            if (!flags) {
                count++;
            }
        }
        return count;
    }

    /**
     * 埃氏筛
     * 我们考虑这样一个事实：如果 x 是质数，那么大于 x 的 x 的倍数 2x,3x, 一定不是质数，因此我们可以从这里入手。
     * 我们设 isPrime[i] 表示数 i 是不是质数，如果是质数则为 1，否则为 0。从小到大遍历每个数，
     * 如果这个数为质数，则将其所有的倍数都标记为合数（除了该质数本身），即 00，这样在运行结束的时候我们即能知道质数的个数。
     */
    public static int countPrimes3(int n) {
        //首先，声明一个长度为n的数组，
        int[] isPrime = new int[n];
        //填充，默认初始值都是质数
        Arrays.fill(isPrime, 1);
        //用来统计当前质数的数量
        int count = 0;
        for (int i = 2; i < n; i++) {
            //如果当前是质数的话 就 +1
            if (isPrime[i] == 1) {
                count++;
                //这里校验防止整型溢出
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        //给后续i的倍数设置成合数
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 埃氏筛优化版本
     * @param n
     * @return
     */
    public static int countPrimes4(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}
