package com.example.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 * socket案例中的客户端
 */
@Slf4j
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        //超时时间
        socket.setSoTimeout(3000);
        //链接本地，端口号为2000 超时时间为3s
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(),2000),3000);
        log.info("发起客户端链接，并进入后续流程");
        log.info("客户端的信息，ip:{},port:{}",socket.getLocalAddress(),socket.getLocalPort());
        log.info("服务端的信息，ip:{},port:{}",socket.getInetAddress(),socket.getPort());
        BufferedWriter writer = null;
        try {
            //创建IO流
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                //等待用户输入信息
                String str = consoleReader.readLine();

                //发送到服务端
                writer.write(str + "\n");
                writer.flush();
                //读取服务器返回的消息
                String msg =  reader.readLine();
                log.info("从服务器中返回的数据为：{}",msg);
                if(str.equalsIgnoreCase("quite")){
                    log.info("客户端【{}】退出",socket.getLocalPort());
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            log.error("异常关闭");
        }finally {
            if(writer != null){
                writer.close();
            }
            log.info("客户端关闭socket");
        }

    }


}
