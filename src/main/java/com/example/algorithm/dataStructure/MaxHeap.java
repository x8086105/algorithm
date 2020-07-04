package com.example.algorithm.dataStructure;

/**
 * 最大堆
 */
public class MaxHeap<E extends Comparable<E>>{

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    public int getSize(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树中数组表示中，一个索引所表示的父亲节点的索引
     * @param index
     * @return
     */
    private int parent(int index){
        if(index == 0){
            throw  new IllegalArgumentException("index-0 doesn't have parent ");
        }
        return (index - 1)/2;
    }

    /**
     * 返回完全二叉树在数组中表示，一个索引所表示的左孩子的节点
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }
    /**
     * 返回完全二叉树在数组中表示，一个索引所表示的右孩子的节点
     * @param index
     * @return
     */
    private int rightChild(int index){
        return index * 2 + 2;
    }

    /**
     * 像堆中添加一个元素
     * @param e
     */
    public void add(E e){
        //1 先将元素加入到数组中
        data.addLast(e);
        //2 对该元素进行上浮操作
        siftUp(data.getSize() - 1);
    }

    /**
     * 对下标为index的元素进行上浮操作
     * @param index
     */
    private void siftUp(int index) {
        //索引不为0并且 当前索引大于其父亲的索引的时候 进行交换
        while (index > 0 && data.get(index).compareTo(data.get(this.parent(index)))>0){
            data.swap(index,this.parent(index));
            index = this.parent(index);
        }
    }

    /**
     * 从堆中取出最大元素
     * @return
     */
    public E extractMax(){
        E maxE = data.get(0);
        this.siftDown(0);
        return maxE;
    }

    /**
     * 获取其左孩子跟右孩子，然后取较大的跟该元素进行替换，直到左右
     * @param i
     */
    private void siftDown(int i) {
        while (this.leftChild(i) <= getSize() || this.rightChild(i) <= getSize()){
            if(this.leftChild(i) > getSize()){
                //当前元素跟右孩子进行交换
                data.swap(i,this.rightChild(i));
                continue;
            }
            if(this.rightChild(i) > getSize()){
                //当前元素跟右孩子进行交换
                data.swap(i,this.leftChild(i));
                continue;
            }
            int exchangeIndex = data.get(leftChild(i)).compareTo(data.get(rightChild(i))) >0?leftChild(i) : rightChild(i);
            data.swap(i,exchangeIndex);
        }
        data.removeLast();
    }

}
