package com.example.studyBase;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

public class ImmutableObjectTest {

    public static void main(String[] args) throws IllegalAccessException {
        ImmutableObject o = new ImmutableObject(10);
        System.out.println(o.getValue());
        Class c =  o.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field f: fields){
            f.setAccessible(true);
            f.set(o,5);
        }
        System.out.println(o.getValue());
    }
}
