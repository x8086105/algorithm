package com.example.algorithm.leetCode;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *  
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 */
public class LeetCode973 {

    public static void main(String[] args) {
//        int [][] points = {{3,3},{5,-1},{-2,4}};int K = 2;
//        int [][]result = kClosest(points,K);
//        System.out.println(result);

        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Collections.rotate(list,3);
        System.out.println(list);
    }

    public static int[][] kClosest(int[][] points, int K) {
        /**
         * 优先级队列，大的元素放在前面
         */
        PriorityQueue<Map<Integer,Integer>> queue = new PriorityQueue<>((o1, o2) -> {

            AtomicReference<Integer> v1 = new AtomicReference<>();
            o1.forEach((k, v) -> {
                v1.set(v);
            });
            AtomicReference<Integer> v2 = new AtomicReference<>();
            o2.forEach((k, v) -> {
                v2.set(v);
            });
            if (v1.get().compareTo(v2.get()) > 0) {
                return 1;
            } else if (v1.get().equals(v2.get())) {
                return 0;
            }
            return -1;
        });
        for(int i = 0;i < points.length; i++){
            Integer x = (int) Math.pow(points[i][0], 2);
            Integer y = (int) Math.pow(points[i][1], 2);
            Map<Integer,Integer> map = new HashMap<>();
            map.put(i,x+y);
            queue.offer(map);
        }
        int [][]result = new int[K][2];
        for(int i = 0; i < K; i++){
            Map<Integer,Integer> map = queue.poll();
            List<Integer> keys = new ArrayList<>(map.keySet());
            result[i][0] = points[keys.get(0)][0];
            result[i][1] = points[keys.get(0)][1];
        }
        return result;

    }

    public static int[][] kClosest2(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }
    public int[][] kClosest3(int[][] points,int K){
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] array1, int[] array2) {
                return array2[0] - array1[0];
            }
        });
        for (int i = 0; i < K; ++i) {
            pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        int n = points.length;
        for (int i = K; i < n; ++i) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < pq.peek()[0]) {
                pq.poll();
                pq.offer(new int[]{dist, i});
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; ++i) {
            ans[i] = points[pq.poll()[1]];
        }
        return ans;
    }
}
