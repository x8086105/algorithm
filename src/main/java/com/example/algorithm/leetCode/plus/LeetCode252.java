package com.example.algorithm.leetCode.plus;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，请你判断一个人是否能够参加这里面的全部会议。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：false
 * 示例 2：
 *
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：true
 *  
 *
 */
public class LeetCode252 {
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i = 1; i < intervals.length;i++){
            if(intervals[i - 1][1] > intervals[i][0]){
                return false;
            }
        }
        return true;
    }
}
