package com.example.mutileThread;

public class Single {

    private Single(){

    }

    private static class InstanceHolder{
        final  static  Single Instance = new Single();
    }

    public static Single getInstance(){
        return InstanceHolder.Instance;
    }

    public void someService(){

    }

    public static void main(String[] args) {
        Single.getInstance().someService();
    }
}
