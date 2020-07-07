package com.example.algorithm.dataStructure;

public interface Merger<E> {
    /**
     * 融合两个元素，返回成一个元素
     * @param e1
     * @param e2
     * @return
     */
    E merge(E e1,E e2);
}
