package com.example.algorithm.leetCode;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

/**
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 *
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 *
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 *
 */
public class LeetCode1356 {

    public static void main(String[] args) {


//        int []arr = {0,1,2,3,4,5,6,7,8};
//        int []result = sortByBits(arr);
//        for(int i : result){
//
//            System.out.println(i);
//        }
        int count = Integer.bitCount(2);
        System.out.println(count);
    }

    public static int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int count = getCount(arr[i]);
            List<Integer> list = resultMap.get(count) == null ? new ArrayList<>() : resultMap.get(count);
            list.add(arr[i]);
            resultMap.put(count,list);
        }
        List<Integer> resultList = Lists.newArrayList();
        resultMap.forEach((k,v)->{
            resultList.addAll(v);
        });
        int[] result = new int[resultList.size()];
        for(int i = 0;i<resultList.size();i++){
            result[i] = resultList.get(i);
        }
        return result;
    }

    private static int getCount(int num){
        int count = 0;
        while (num > 0){
            num = num & (num - 1);
            count++;
        }
        return count;
    }


}
