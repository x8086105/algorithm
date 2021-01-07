package com.example.socket.mutileChat;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AIOChatClient {

    private static final String LOCALHOST = "localhost";

    private static final int DEFAULT_PORT = 8888;

    private static final String QUIT = "quit";

    private static final int BUFFER = 1024;

    private String host;

    private int port;

    private AsynchronousSocketChannel clientChannel;

    private Charset charset = Charset.forName("utf-8");

    public AIOChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public AIOChatClient() {
        this(LOCALHOST,DEFAULT_PORT);
    }

    /**
     * 当输入"quit"时表示客户退出
     * @param msg
     * @return
     */
    public boolean readyToQuit(String msg){
        return QUIT.equals(msg);
    }

    /**
     * 关闭相对应的流并释放与之相关联的任何系统资源,如果流已关闭,则调用此方法将不起任何作用
     * @param closeable
     */
    private void close(Closeable closeable){
        if (closeable!=null){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void start(){
        //创建channel
        try {
            clientChannel = AsynchronousSocketChannel.open();
            Future<Void> future = clientChannel.connect(new InetSocketAddress(host,port));
            future.get();
            //阻塞式调用
            //异步调用用户输入
            //启动一个新的线程用于处理用户的输入
            new Thread(new UserInputHandler2(this)).start();
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER);
            //读取从服务器中转发的消息
            while (true){
                //启动异步读操作,从该通道读取到给定的缓冲区字节序列
                Future<Integer> readResult = clientChannel.read(buffer);
                //Future的get方法返回从通道中读取的字节数的大小
                int result = readResult.get();
                if (result<=0){
                    //无法从服务器读取到信息,服务器异常
                    System.out.println("服务器断开");
                    //同时将客户端也关闭
                    close(clientChannel);
                    //0是正常退出,非0是不正常退出
                    System.exit(1);
                }else {
                    //将读模式转换为写模式
                    buffer.flip();
                    String msg = String.valueOf(charset.decode(buffer));
                    //每次将缓冲区的内容写出来后都将缓冲区数据清空
                    buffer.clear();
                    System.out.println(msg);
                }
            }
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void send(String msg){
        if (msg.isEmpty()){
            //未输入信息,没有必要向服务发送内容
            return;
        }
        //将要发送的数据进行utf-8加码
        ByteBuffer buffer = charset.encode(msg);
        //将要发送的数据写入缓冲区中
        Future<Integer> writeResult = clientChannel.write(buffer);
        try {
            writeResult.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("消息发送失败");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AIOChatClient chatClient = new AIOChatClient("127.0.0.1",7777);
        chatClient.start();
    }

}
