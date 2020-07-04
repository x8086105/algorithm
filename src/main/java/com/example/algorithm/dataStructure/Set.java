package com.example.algorithm.dataStructure;

/**
 * 集合的底层实现
 * @param <E>
 */
public interface Set<E> {
    /**
     * 添加元素，不能存在重复元素
     * @param e
     */
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
