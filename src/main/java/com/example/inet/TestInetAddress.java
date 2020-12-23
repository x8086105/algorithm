package com.example.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {

    public static void main(String[] args) throws UnknownHostException {
        String host = getByAddress("www.baidu.com");
        System.out.println(host);
    }

    private static String getByAddress(String domain) throws UnknownHostException {
        InetAddress i = InetAddress.getByName(domain);
        System.out.println(i);
        return i.getHostAddress();

    }
}
