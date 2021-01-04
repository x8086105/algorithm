package com.example.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class Server {

    public static void main(String[] args) {
        final int DEFALUT_PORT = 2000;
        ServerSocket serverSocket = null;

        //绑定监听端口
        try {
            serverSocket = new ServerSocket(DEFALUT_PORT);
            log.info("启动服务器，监听端口：{}", DEFALUT_PORT);
            while (true) {
                //返回服务器跟客户端交互的套接字
                //等待 客户端连接
                Socket socket = serverSocket.accept();
                log.info("客户端【{}】已经连接了", socket.getPort());
                Thread taskThread = new Thread(new Task(socket));
                taskThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Task implements Runnable{

        private Socket socket;

        public Task(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                //为了让多个客户端同时连接 这里应该用多线程来解决这个问题

                //读取客户端发送的消息
                String msg = null;
                while ( (msg = reader.readLine()) != null) {

                    log.info("客户端【{}】发送的消息是:{}", socket.getPort(), msg);
                    //回复客户发送的消息
                    writer.write("服务器：" + msg + "\n");
                    writer.flush();
                    if (msg.equalsIgnoreCase("quite")) {

                        log.info("客户端【{}】已退出", socket.getPort());
                    }

                }
            }catch (IOException e){

            }

        }
    }
}
