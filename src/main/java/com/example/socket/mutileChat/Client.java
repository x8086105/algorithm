package com.example.socket.mutileChat;

import lombok.extern.slf4j.Slf4j;
import sun.reflect.generics.scope.Scope;

import java.io.*;
import java.net.*;

@Slf4j
public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        //链接本地，端口号为2000 超时时间为3s
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 2000));
        log.info("发起客户端连接，并进入后续流程");
        log.info("客户端的信息，ip:{},port:{}", socket.getLocalAddress(), socket.getLocalPort());
        log.info("服务端的信息，ip:{},port:{}", socket.getInetAddress(), socket.getPort());

        //开启监听（从服务器中监听）
        Task task = new Task(socket);
        task.start();

        try {
            //创建IO流
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                String mesage = reader.readLine();
                if(mesage.equalsIgnoreCase("quite")){
                    break;
                }
                log.info(mesage);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }

    private static class Task extends Thread {

        private Socket socket;

        public Task(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedWriter writer = null;
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                while (true) {

                    BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

                    String msg = consoleReader.readLine();
                    writer.write(msg + "\n");
                    writer.flush();
                    if (msg.equalsIgnoreCase("quite")) {
                        log.info("客户端退出");
                        break;
                    }
                }


            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }
        }
    }
}
