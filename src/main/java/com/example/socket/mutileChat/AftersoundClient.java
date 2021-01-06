package com.example.socket.mutileChat;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 回音壁客户端
 */
public class AftersoundClient {
    final String LOCALHOST = "localhost";
    final int DEFAULT_PORT = 8888;
    AsynchronousSocketChannel clientChannel;

    private void close(Closeable closeable){
        if(closeable != null){
            try {
                closeable.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
    
    public void start(){
        try {
            clientChannel = AsynchronousSocketChannel.open();
            Future<Void> future = clientChannel.connect(new InetSocketAddress(LOCALHOST,DEFAULT_PORT));
            future.get();
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                String input = consoleReader.readLine();
                //将客户输入的信息发送给服务器，从服务器收到的消息显示出来
                byte[] bytes= input.getBytes();
                ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
                Future<Integer> writeResult = clientChannel.write(byteBuffer);
                writeResult.get();
                byteBuffer.flip();
                Future<Integer> readResult =  clientChannel.read(byteBuffer);
                readResult.get();
                String echo = new String(byteBuffer.array());
                byteBuffer.clear();
                System.out.println(echo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            close(clientChannel);
        }

    }

    public static void main(String[] args) {
        AftersoundClient client = new AftersoundClient();
        client.start();
    }

}
