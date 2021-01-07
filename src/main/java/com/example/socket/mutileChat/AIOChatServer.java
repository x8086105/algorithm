package com.example.socket.mutileChat;

import com.google.common.collect.Lists;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.*;

public class AIOChatServer {

    /**
     * 需要连接的服务端的地址
     */
    private static final String LOCALHOST = "localhost";
    /**
     * 需要连接的服务端的端口号
     */
    private static final int DEFAULT_PORT = 8888;

    private static final String QUIT = "quit";

    private static final int BUFFER = 1024;

    private static final int THREADPOOL_SIZE = 8;

    private AsynchronousChannelGroup channelGroup;

    private AsynchronousServerSocketChannel serverChannel;

    private List<ClientHandler> connectedClients;

    private Charset charset = Charset.forName("UTF-8");

    private int port;

    public AIOChatServer() {
        this(DEFAULT_PORT);
    }

    public AIOChatServer(int port) {
        this.port = port;
        this.connectedClients = Lists.newArrayList();
    }

    private boolean readyToQuit(String msg) {
        return msg.equals(QUIT);
    }

    /**
     * 关闭所有的流（可用的方法）
     *
     * @param closeable
     */
    private void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        //ExecutorService executorService = Executors.newFixedThreadPool(THREADPOOL_SIZE);

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(THREADPOOL_SIZE, THREADPOOL_SIZE,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        try {
            channelGroup = AsynchronousChannelGroup.withThreadPool(poolExecutor);
            serverChannel = AsynchronousServerSocketChannel.open(channelGroup);
            serverChannel.bind(new InetSocketAddress(LOCALHOST, port));
            System.out.println("启动服务器，监听端口：" + port);
            while (true){//循环是为了防止还没进行回调 这里就执行完了
                serverChannel.accept(null, new AcceptHandler());
                //下面这个是阻塞，为了不让他重复
                System.in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel,Object> {
        @Override
        public void completed(AsynchronousSocketChannel clientChannel, Object attachment) {
            //如果服务器是开启的状态，继续监听接下来的请求
            if(serverChannel.isOpen()){
                serverChannel.accept(null,this);
            }
            //处理接纳建立连接的客户端
            if(clientChannel != null && clientChannel.isOpen()){
                ClientHandler clientHandler = new ClientHandler(clientChannel);
                ByteBuffer buffer = ByteBuffer.allocate(BUFFER);
                // TODO: 2021/1/7 将新用户添加到在线用户列表
                addClient(clientHandler);
                //第一个buffer而对象，是告诉系统，将系统读到的数据写入到这个buffer中
                //第二个buffer对象呢，为了后续clientHandler这个回调函数调用的时候，传进去
                clientChannel.read(buffer,buffer,clientHandler);
            }
        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            System.out.println("连接失败:" + exc);
        }
    }



    private class ClientHandler implements CompletionHandler<Integer,Object>{
        private AsynchronousSocketChannel client;

        public ClientHandler(AsynchronousSocketChannel client){
            this.client = client;
        }

        @Override
        public void completed(Integer result, Object attachment) {
            ByteBuffer buffer = (ByteBuffer) attachment;
            if(buffer != null){
                //处理的是刚刚完成的read的调用
                if(result <= 0){
                    //客户端的异常
                    // TODO: 2021/1/7 将客户从在线客户列表中移除出去
                    removeClient(this);
                }else{
                    buffer.flip();
                    String msg = receive(buffer);
                    forwardMessage(client,msg);
                    //清除缓冲区
                    buffer.clear();
                    //检查用户是否退出
                    if (readyToQuit(msg)){
                        //将客户从在线客户列表中去除
                        removeClient(this);
                    }else {
                        //如果不是则继续等待读取用户输入的信息
                        client.read(buffer,buffer,this);
                    }

                }
            }
        }
        @Override
        public void failed(Throwable exc, Object attachment) {

        }

    }

    /**
     * 添加客户端到在线列表中
     * @param clientHandler
     */
    private void addClient(ClientHandler clientHandler) {

        connectedClients.add(clientHandler);
        System.out.println(getClientName(clientHandler.client)+"已经连接到服务器");
    }

    private void removeClient(ClientHandler clientHandler) {
        connectedClients.remove(clientHandler);
        System.out.println(getClientName(clientHandler.client)+"已断开连接");
        //关闭该客户对应流
        close(clientHandler.client);
    }

    private String receive(ByteBuffer buffer) {
        CharBuffer charBuffer = charset.decode(buffer);
        return String.valueOf(charBuffer);
    }

    /**
     * 获取客户端的名称
     * @param socketChannel
     * @return
     */
    private String getClientName(AsynchronousSocketChannel socketChannel){
        int clientPort = -1;
        try {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketChannel.getRemoteAddress();
            clientPort = inetSocketAddress.getPort();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "客户端["+clientPort+"]:";
    }


    private void forwardMessage(AsynchronousSocketChannel clientChannel,String msg) {
        for (ClientHandler handler:connectedClients){
            //该信息不用再转发到发送信息的那个人那
            if (!handler.client.equals(clientChannel)){
                try {
                    //将要转发的信息写入到缓冲区中
                    ByteBuffer buffer = charset.encode(getClientName(handler.client)+":"+msg);
                    //将相应的信息写入到用户通道中,用户再通过获取通道中的信息读取到对应转发的内容
                    handler.client.write(buffer,null,handler);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        AIOChatServer server = new AIOChatServer(7777);
        server.start();
    }
}
