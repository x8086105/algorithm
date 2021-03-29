package com.example.studyBase;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

/**
 * 这不就是个反射么
 */
public class ImmutableObjectTest {

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
//        System.out.println(o.getValue());
    }
}
