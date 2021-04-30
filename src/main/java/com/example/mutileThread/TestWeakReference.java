package com.example.mutileThread;

import com.example.Mom;
import com.example.Person;

import java.lang.ref.WeakReference;
import java.util.Objects;

public class TestWeakReference {

    public static void main(String[] args) {
        //注意，这里做实验的话，一定要避开Integer的IntegerCache的范围。因为IntegerCache是不会回收的
        WeakReference<Integer> s = new WeakReference<Integer>(128);
        System.out.println(s.get());
        helpGC();
        System.out.println(s.get());
        testWeakReference();
    }
    private static void helpGC(){
        byte[] bytes = new byte[1024 * 1024];
        bytes = new byte[1024 * 1024];
        bytes = new byte[1024 * 1024];
        bytes = null;
        byte[] bytes2 = new byte[2 * 1024 * 1024];
    }
    private static void testWeakReference(){
        Mom m = new Mom(1,"mm");
        Person p = new Person(2,"22",new WeakReference<>(m));
        System.out.println(p.getMom().get());
        //帮助GC 这里如果不这样调用的话，就会出现m一直有强引用在，所以p里面的m不会被回收
        m = null;
        helpGC();
        System.out.println(p.getMom().get());

    }
}
