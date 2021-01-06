package com.example.socket.mutileChat;

import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Set;

@Slf4j
public class ChatClient {
    /***
     * 服务器默认的地址
     */
    private static final String DEFAULT_SERVER_HOST = "127.0.0.1";
    /**
     * 服务器默认的端口号
     */
    private static final int DEFAULT_SERVER_PORT = 8888;
    /**
     * 中止通话的字符串
     */
    private static final String QUIT = "quit";
    /**
     * 默认缓存的大小
     */
    private static final int BUFFER = 1024;
    /**
     * 客户端的channel
     */
    private SocketChannel client;
    /**
     * 选择器
     */
    private Selector selector;
    /**
     * 选择器，也称为多路复用
     */
    private ByteBuffer rBuffer = ByteBuffer.allocate(BUFFER);

    private ByteBuffer wBuffer = ByteBuffer.allocate(BUFFER);

    private Charset charset = Charset.forName("UTF-8");

    private String host;
    private int port;

    public ChatClient(){
        this(DEFAULT_SERVER_HOST,DEFAULT_SERVER_PORT);
    }

    public ChatClient(String host,int port){
        this.host = host;
        this.port = port;
    }

    public boolean readyToQuit(String msg) {
        return msg.equals(QUIT);
    }

    private void close(Closeable closeable){
        if(closeable != null){
            try {
                closeable.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void start(){
        try {
            client = SocketChannel.open();
            client.configureBlocking(false);

            selector = Selector.open();
            client.register(selector, SelectionKey.OP_CONNECT);
            client.connect(new InetSocketAddress(host,port));

            while (true){
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for(SelectionKey key : selectionKeys){
                    handlers(key);
                }
                selectionKeys.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClosedSelectorException e){
            //属于用户正常退出

        }finally {
            close(selector);
        }

    }

    private void handlers(SelectionKey key) throws IOException {
        //CONNECT事件，----连接事件
        if(key.isConnectable()){
//            SocketChannel client = (SocketChannel) key.channel();
            if(client.isConnectionPending()){
                client.finishConnect();
                log.info("客户端【{}】已连接",client.socket().getLocalPort());
                //处理用户输入
                new Thread(new UserInputHandler(this)).start();
            }
            client.register(selector,SelectionKey.OP_READ);
        }
        //READ事件----读事件
        else if(key.isReadable()){
//            SocketChannel client = (SocketChannel) key.channel();
            String msg = receive(client);
            if(StringUtils.isBlank(msg)){
                //服务器端意外关闭了这个通道
                close(selector);
            }else{
                System.out.println(msg);
            }
        }
    }
    public void send(String msg)throws  IOException {
        if (StringUtils.isBlank(msg)) {
            return;
        }

        wBuffer.clear();
        wBuffer.put(charset.encode(msg));
        wBuffer.flip();
        while (wBuffer.hasRemaining()){
            client.write(wBuffer);
        }

        if(readyToQuit(msg)){
            close(selector);
        }

    }
    private String receive(SocketChannel client) throws IOException{
        rBuffer.clear();
        while (client.read(rBuffer)>0);
        rBuffer.flip();
        return String.valueOf(charset.decode(rBuffer));
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient("127.0.0.1",7777);
        client.start();
    }
}
