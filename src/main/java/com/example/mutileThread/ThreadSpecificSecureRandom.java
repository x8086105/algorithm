package com.example.mutileThread;

import java.net.InetAddress;
import java.net.Socket;
import java.security.SecureRandom;

public enum ThreadSpecificSecureRandom {

    INSTANCE;

    final static ThreadLocal<SecureRandom> SECURE_RANDOM = new ThreadLocal<SecureRandom>(){
        @Override
        protected SecureRandom initialValue() {
            SecureRandom srnd;
            try {
                srnd = SecureRandom.getInstance("SHA1PRNG");
            }catch (Exception e){
                srnd = new SecureRandom();
                e.printStackTrace();
            }
            srnd.nextBytes(new byte[20]);
            return srnd;
        }
    };

    public int nextInt(int upperBound){
        SecureRandom random = SECURE_RANDOM.get();
        return random.nextInt(upperBound);
    }

    public void setSeed(int seed){
        SecureRandom random = SECURE_RANDOM.get();
        random.setSeed(seed);
    }


    public static void main(String[] args) {

        ThreadSpecificSecureRandom.INSTANCE.setSeed(10);
        int i = ThreadSpecificSecureRandom.INSTANCE.nextInt(20);
        System.out.println(i);
    }

}
