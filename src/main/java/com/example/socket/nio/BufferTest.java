package com.example.socket.nio;

import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

@Slf4j
public class BufferTest {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String s = "王八蛋";
        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            byteBuffer.put(bytes[i]);
        }
        byteBuffer.flip();
        for (int i = 0; i < byteBuffer.limit(); i++) {
            byte b = byteBuffer.get();
            log.info(b + "");
            log.info("capacity:{},limit:{},position:{}", byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position());
        }
        byteBuffer.rewind();
        byteBuffer.mark();
        for (int i = 0; i < byteBuffer.limit(); i++) {
            byte b = byteBuffer.get();
            log.info(b + "");
            log.info("capacity:{},limit:{},position:{}", byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position());
        }
    }
}
