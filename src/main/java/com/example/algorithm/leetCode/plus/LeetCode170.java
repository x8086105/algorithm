package com.example.algorithm.leetCode.plus;

import java.util.HashMap;
import java.util.Map;

/**
 * 170. 两数之和 III - 数据结构设计
 * 设计一个接收整数流的数据结构，该数据结构支持检查是否存在两数之和等于特定值。
 *
 * 实现 TwoSum 类：
 *
 * TwoSum() 使用空数组初始化 TwoSum 对象
 * void add(int number) 向数据结构添加一个数 number
 * boolean find(int value) 寻找数据结构中是否存在一对整数，使得两数之和与给定的值相等。如果存在，返回 true ；否则，返回 false 。
 *
 *
 * 示例：
 *
 * 输入：
 * ["TwoSum", "add", "add", "add", "find", "find"]
 * [[], [1], [3], [5], [4], [7]]
 * 输出：
 * [null, null, null, null, true, false]
 *
 * 解释：
 * TwoSum twoSum = new TwoSum();
 * twoSum.add(1);   // [] --> [1]
 * twoSum.add(3);   // [1] --> [1,3]
 * twoSum.add(5);   // [1,3] --> [1,3,5]
 * twoSum.find(4);  // 1 + 3 = 4，返回 true
 * twoSum.find(7);  // 没有两个整数加起来等于 7 ，返回 false
 *
 */
public class LeetCode170 {
    /**
     * 这个方法使用HashMap进行存储，其key是添加的值， value是个数
     * find的时候只需要遍历一遍map的key 查找出相差的值，然后判断这个值
     * 是否存在在map中就行了（注意，如果跟当前key相等，则要判断他的value是否大于1）
     */
    class TwoSum {
        private HashMap<Integer,Integer> map;
        /**
         * Initialize your data structure here.
         */
        public TwoSum() {
            map = new HashMap<>();
        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            map.put(number, map.get(number) == null ? 1 : map.get(number) + 1);
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                int v = value - entry.getKey();
                if(v != entry.getKey()){
                    if(map.containsKey(v)){
                        return true;
                    }
                }else{
                    if(entry.getValue() > 1){
                        return true;
                    }
                }
            }
            return false;
        }
    }
    /**
     * Your TwoSum object will be instantiated and called as such:
     * TwoSum obj = new TwoSum();
     * obj.add(number);
     * boolean param_2 = obj.find(value);
     */
}
