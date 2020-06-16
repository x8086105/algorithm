package com.example.algorithm.dataStructure;

public interface Queue<E> {
    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 拿到队首的元素
     * @return
     */
    E getFront();

    /**
     * 获取长度
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();
}
