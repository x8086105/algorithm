package com.example.mutileThread;

public class ServerStarter {

    public static void main(String []args){
        ServiceManager.startService();

        boolean allIsOk ;

        allIsOk = ServiceManager.checkServiceStatus();

        if(allIsOk){
            System.out.println("All Service were successfully started");
        } else {
            System.out.println("some Service failed to start,exiting JVM...");
            System.exit(1);
        }
    }
}
