package com.example.studyBase;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 这不就是个反射么
 */
public class ImmutableObjectTest {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int RUNNING    = -1 << COUNT_BITS;
    //关闭状态，当调用 shutdown() 方法后处于这个状态，任务队列中的任务会继续处理，但不再接受新任务，
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    //停止状态，当调用 shutdownNow() 方法后处于这个状态
    //任务队列中的任务也不再处理且作为方法返回值返回，此后不再接受新任务
    private static final int STOP       =  1 << COUNT_BITS;
    //TERMINATED 之前的临时状态，当线程都被回收且任务队列已清空后就会处于这个状态
    private static final int TIDYING    =  2 << COUNT_BITS;
    //终止状态，在处于 TIDYING 状态后会立即调用 terminated() 方法，调用完成就会马上转到此状态
    private static final int TERMINATED =  3 << COUNT_BITS;

    public static void main(String[] args) throws IllegalAccessException {


        Integer max = Integer.MAX_VALUE;
        System.out.println(max + 2);
        

        Integer min = Integer.MIN_VALUE;
        System.out.println(min);
//        ImmutableObject o = new ImmutableObject(10);
//        System.out.println(o.getValue());
//        Class c =  o.getClass();
//        Field[] fields = c.getDeclaredFields();
//        for (Field f: fields){
//            f.setAccessible(true);
//            f.set(o,5);
//        }

//        ConcurrentHashMap<Integer,String> hashMap = new ConcurrentHashMap<>();
//        hashMap.size();
//
//        System.out.println(RUNNING>>29);
//        System.out.println(SHUTDOWN>>29);
//        System.out.println(STOP>>29);
//        System.out.println(TIDYING>>29);
//        System.out.println(TERMINATED>>29);
        hhh:
        for (int i =0;i<10;i++) {
            System.out.println(1111);
            // 内层循环，worker + 1
            for (; ; ) {
                System.out.println(333);

                if (1 == 1)
                    continue hhh;
            }
        }
        System.out.println(212);
    }
}
