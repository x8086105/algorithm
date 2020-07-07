package com.example.algorithm.Demo;

import com.example.algorithm.dataStructure.Merger;
import com.example.algorithm.dataStructure.SegmentTree;

public class SegementTreeDemo {
    public static void main(String[] args) {
        Integer[] nums = {-2,0,3,-5,2,-1};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer e1, Integer e2) {
                return e1 + e2;
            }
        });

        System.out.println(segTree);
        Integer count = segTree.query(0,5);
        System.out.println(count);
    }
}
