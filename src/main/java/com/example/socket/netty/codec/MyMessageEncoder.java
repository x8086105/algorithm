package com.example.socket.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 自定义编码器
 */
public class MyMessageEncoder extends MessageToByteEncoder<String> {

    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf out) throws Exception {
        System.out.println("MyMessageEncoder encode");
        ctx.writeAndFlush(msg);

    }
}
