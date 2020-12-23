package com.example.mutileThread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class ServiceManager {

    static volatile CountDownLatch latch;
    static Set<Service> services;

    public static void startService(){
        services = getServices();
        for(Service service : services){
            service.start();
        }
    }

    public static boolean checkServiceStatus(){
        boolean allisOK = true;
        try {
            latch.await();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        for (Service service:services){
            if(!service.isStarted()){
                allisOK = false;
                break;
            }
        }
        return allisOK;
    }

    static Set<Service> getServices(){
        latch = new CountDownLatch(3);
        HashSet<Service> servcies =new HashSet<Service> ();
        servcies.add(new SampleServiceA(latch));
        servcies.add(new SampleServiceB(latch));
        servcies.add(new SampleServiceC(latch));
        return servcies;
    }
}
