package com.example;

public class SingletonDemo {

    private SingletonDemo(){

    }

    //懒汉式单例
    private volatile static SingletonDemo singletonDemo = null;

    public static SingletonDemo getInstance(){
        if(singletonDemo == null){
            synchronized (SingletonDemo.class){
                if (singletonDemo == null){
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }


}
