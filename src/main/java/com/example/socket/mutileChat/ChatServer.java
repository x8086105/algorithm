package com.example.socket.mutileChat;

import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * 多人聊天室优化版
 * 使用NIO实现
 */
@Slf4j
public class ChatServer {
    /***
     * 服务端的serverSocketChannel
     */
    private ServerSocketChannel server;
    /**
     * 默认端口号
     */
    private static final int DEFAULT_PORT = 8888;
    /**
     * 中止通话的字符串
     */
    private static final String QUIT = "quit";
    /**
     * 默认缓存的大小
     */
    private static final int BUFFER = 1;
    /**
     * 选择器，也称为多路复用
     */
    private Selector selector;
    private ByteBuffer rBuffer = ByteBuffer.allocate(BUFFER);
    private ByteBuffer wBuffer = ByteBuffer.allocate(BUFFER);
    private Charset charset = Charset.forName("UTF-8");

    private int port;

    public ChatServer() {
        this(DEFAULT_PORT);
    }

    public ChatServer(int port) {
        this.port = port;
    }

    /**
     * 核心方法，用来开启服务端
     */
    private void start() {
        try {
            server = ServerSocketChannel.open();
            //设置成非阻塞
            server.configureBlocking(false);
            //绑定本地端口
            server.bind(new InetSocketAddress(port));
            selector = Selector.open();
            //注册接收事件到选择器上 监听...
            server.register(selector, SelectionKey.OP_ACCEPT);
            log.info("启动服务器，监听端口:{}...", port);
            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey selectionKey : selectionKeys) {

                    handlers(selectionKey);
                }
                selectionKeys.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            close(selector);
        }
    }

    private void handlers(SelectionKey selectionKey) throws IOException{
        //ACCEPT事件--与客户端建立连接
        if(selectionKey.isAcceptable()){
            ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
            SocketChannel client = server.accept();
            client.configureBlocking(false);
            //开始进行监听read事件
            client.register(selector,SelectionKey.OP_READ);
            log.info("{}已连接",getClientName(client));
        }
        //READ事件，客户端发送了消息
        //底层采用了 与运算boolean isInterestedInRead    = readyOps & SelectionKey.OP_READ;
        else if (selectionKey.isReadable()){
            SocketChannel client = (SocketChannel) selectionKey.channel();
            String msg = receive(client);

            if(StringUtils.isEmpty(msg)){
                //客户端异常
                selectionKey.cancel();
                selector.wakeup();
            }else{
                log.info("{}: {}",getClientName(client), msg);
                forwardMessage(client,msg);
                //检查用户是否退出
                if(readyToQuit(msg)){
                    selectionKey.cancel();
                    selector.wakeup();
                    log.info("{}已退出",getClientName(client));
                }
            }

        }

    }

    private boolean readyToQuit(String msg) {
        return msg.equals(QUIT);
    }

    private void forwardMessage(SocketChannel client, String msg) throws IOException {
        //返回目前注册在selector上的所有channel
        for(SelectionKey key : selector.keys()){
            Channel connectedChannel = key.channel();
            //过滤掉服务端的channel
            if(connectedChannel instanceof ServerSocketChannel){
                continue;
            }
            //有效的socketChannel
            if(key.isValid() && !client.equals(connectedChannel)){
                wBuffer.clear();
                wBuffer.put(charset.encode(getClientName(client) + ":" + msg));
                //写模式转变成读模式
                wBuffer.flip();
                while (wBuffer.hasRemaining()){
                    ((SocketChannel)connectedChannel).write(wBuffer);
                }
            }
        }

    }

    private String getClientName(SocketChannel client){
        return "客户端【"+ client.socket().getPort() + "】";
    }

    private String  receive(SocketChannel client) throws IOException {
        rBuffer.clear();
        //将数据读到rBuffer中
        while (client.read(rBuffer) > 0) {

        }
        //从写模式转变成读模式
        rBuffer.flip();
        return String.valueOf(charset.decode(rBuffer));
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

    public static void main(String[] args) {
        ChatServer server = new ChatServer(7777);
        server.start();
    }
}
