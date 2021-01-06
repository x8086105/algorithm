package com.example.socket.mutileChat;

import ch.qos.logback.core.encoder.ByteArrayUtil;
import com.google.common.collect.Maps;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Map;

/**
 * 回音壁服务端
 */
public class AftersoundServer {
    /**
     * 需要连接的服务端的地址
     */
    private static final String LOCALHOST = "localhost";
    /**
     * 需要连接的服务端的端口号
     */
    private static final int DEFAULT_PORT = 8888;

    AsynchronousServerSocketChannel serverChannel;

    public AftersoundServer(){

    }

    private void close(Closeable closeable){
        if(closeable != null){
            try {
                closeable.close();
                System.out.println("关闭" + closeable);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void start(){
        //绑定监听端口
        try {
            //AsynchronousChannelGroup 类似于线程池，提供异步的通道共享
            serverChannel = AsynchronousServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress(LOCALHOST,DEFAULT_PORT));
            System.out.println("启动服务器，监听端口号:" +  DEFAULT_PORT);
            /**
             * attchment 类似于额外的参数  附件等，但是这里不需要，就没必要传这个参数了
             */
            while (true){
                serverChannel.accept(null,new AcceptHandler());
                //阻塞
                System.in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            close(serverChannel);
        }

    }

    /**
     * 回调函数
     */
    private class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel,Object> {


        @Override
        public void completed(AsynchronousSocketChannel result, Object attachment) {
            if(serverChannel.isOpen()){
                serverChannel.accept(null,this);
            }
            AsynchronousSocketChannel clientChannel = result;
            if(clientChannel != null && clientChannel.isOpen()){
                ClientHandler clientHandler = new ClientHandler(clientChannel);

                //从客户端读
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                Map<String,Object> info = Maps.newHashMap();
                info.put("type","read");
                info.put("buffer",byteBuffer);

                clientChannel.read(byteBuffer,info,clientHandler);
            }

        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            exc.printStackTrace();
        }
    }

    private class ClientHandler implements CompletionHandler<Integer,Object>{

        private AsynchronousSocketChannel clientChannel;

        public ClientHandler(AsynchronousSocketChannel clientChannel){
            this.clientChannel = clientChannel;
        }

        @Override
        public void completed(Integer result, Object attachment) {
            //从客户端通道里读到的数据拿出来，然后打印，然后在返回过去
            Map<String,Object> info = (Map<String, Object>) attachment;
            String type = info.get("type").toString();
            if("read".equals(type)){
                ByteBuffer byteBuffer = (ByteBuffer) info.get("buffer");
                //由写模式变为读模式
                byteBuffer.flip();
                info.put("type","write");
                System.out.println("write:" + new String(byteBuffer.array()));
                clientChannel.write(byteBuffer,info,this);
                byteBuffer.clear();
            }else if("write".equals(type)){
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                info.put("type","read");
                info.put("buffer",byteBuffer);
                System.out.println("read:" + new String(byteBuffer.array()));
                clientChannel.read(byteBuffer,info,this);
            }
        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            exc.printStackTrace();
        }
    }
    public static void main(String[] args) {
        AftersoundServer server = new AftersoundServer();
        server.start();
    }
}
