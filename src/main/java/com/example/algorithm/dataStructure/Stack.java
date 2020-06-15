package com.example.algorithm.dataStructure;

/**
 * 数组栈
 */
public interface Stack<E> {
    /**
     * 添加元素到栈顶
     * @param e
     */
    void push(E e);

    /**
     *
     * @return
     */
    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
