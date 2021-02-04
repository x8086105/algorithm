package com.example.socket.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 自定义解码器
 */
public class MyMessageDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyMessageDecoder decode");
        //解码 读取信息放到out 列表里，他会转发到下个inbound的handler中
//        if(in.readableBytes() > 0){
//            out.add(in.readerIndex());
//        }
    }
}
