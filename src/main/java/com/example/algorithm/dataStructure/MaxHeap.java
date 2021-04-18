package com.example.algorithm.dataStructure;

/**
 * 最大堆
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 使用heapify的方式将一个数组元素添加到堆元素中
     *
     * @param arr
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(data.getSize() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树中数组表示中，一个索引所表示的父亲节点的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent ");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树在数组中表示，一个索引所表示的左孩子的节点
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树在数组中表示，一个索引所表示的右孩子的节点
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 像堆中添加一个元素
     *
     * @param e
     */
    public void add(E e) {
        //1 先将元素加入到数组中
        data.addLast(e);
        //2 对该元素进行上浮操作
        siftUp(data.getSize() - 1);
    }

    /**
     * 对下标为index的元素进行上浮操作
     *
     * @param index
     */
    private void siftUp(int index) {
        //索引不为0并且 当前索引大于其父亲的索引的时候 进行交换
        while (index > 0 && data.get(index).compareTo(data.get(this.parent(index))) > 0) {
            data.swap(index, this.parent(index));
            index = this.parent(index);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("can not findMax when heap is empty");
        }
        return data.get(0);

    }

    /**
     * 从堆中取出最大元素
     * 下沉元素不一定下沉到数组的最后一个元素，
     * 所以这里应该直接删除
     *
     * @return
     */
    public E extractMax() {
        E maxE = findMax();
        //当前最大元素与末尾元素进行交换位置，然后delete掉
        data.swap(0, data.getSize() - 1);
        //这里是delete掉的
        data.removeLast();
        //然后下沉操作
        this.siftDown(0);
        //返回回去需要删除的元素
        return maxE;
    }


    /**
     * 获取其左孩子跟右孩子，然后取较大的跟该元素进行替换，直到左右
     *
     * @param k
     */
    private void siftDown(int k) {
        //左孩子的节点是否小于总数量，也就是判断当前节点是否是叶子节点
        while (this.leftChild(k) < getSize()) {
            int j = leftChild(k);
//            E  leftE = data.get(j);
//            E curE = data.get(k);
            //右孩子不为空 并且右孩子大于左孩子
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            //此时j是左右孩子中最大的（判断当前节点是否大于左孩子节点）
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            //交换位置
            data.swap(k, j);
            //赋值操作
            k = j;
        }
    }

    /**
     * 替换最大元素，并且返回最大元素
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E maxE = findMax();
        data.set(0, e);
        this.siftDown(0);
        return maxE;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
