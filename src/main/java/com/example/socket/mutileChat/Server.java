package com.example.socket.mutileChat;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * 多人聊天室 服务端
 */
@Slf4j
public class Server {
    /**
     * 用来存储客户端连接上来的socketList
     */
    private static List<Socket> socketList ;

    private static  final  int PORT = 2000;

    static {
        socketList = Lists.newArrayList();

    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true){
            Socket socket = serverSocket.accept();
            log.info("服务器启动，监听端口号:{}",socket.getLocalPort());
            socketList.add(socket);
            log.info("客户端已经连接：{}",socket.getPort());
            Task task = new Task(socket);
            Thread t = new Thread(task);
            t.start();
        }

    }

    /**
     * 用于接收客户端发送来的消息
     */
    private static class Task implements Runnable{
        /**
         * socket
         */
        private Socket socket;

        public Task(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                //声明IO流
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //从客户端读出信息

                String msg;
                while ((msg = reader.readLine()) != null){
                    //将该客户端发来的消息，转发到其他客户端
                    msg = "客户端【" + socket.getPort() + "】说：" + msg;
                    if(msg.equalsIgnoreCase("quite")){
                        log.info("客户端【{}】退出",socket.getPort());
                        msg = "客户端【" + socket.getPort() + "】退出";
                        socketList.remove(socket);
                    }
                    for(Socket cSocket : socketList){
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(cSocket.getOutputStream()));
                        writer.write(msg + "\n");
                        writer.flush();
                    }

                }


            } catch (IOException e) {
                e.printStackTrace();
            }finally {

            }
        }
    }
}
