package com.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.ref.WeakReference;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int age;

    private String name;

    //测试一个弱引用
    private WeakReference<Mom> mom;


}
