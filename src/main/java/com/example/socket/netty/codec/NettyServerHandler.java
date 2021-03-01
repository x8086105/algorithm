package com.example.socket.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * 服务端的handler
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private int count;
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
//        //从客户端接收到数据，并进行处理
//        System.out.println("从客户端接收到消息:" + msg);
//        System.out.println("服务器接收到消息包数量=" + (++this.count));
//        String responseContent = UUID.randomUUID().toString();
//        ctx.writeAndFlush(responseContent);
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] buffer = new byte[msg.readableBytes()];
        msg.readBytes(buffer);
        String s = new String(buffer, StandardCharsets.UTF_8);
        System.out.println("服务器端接收到数据:" + s);
        System.out.println("服务器端接收到的消息量：" + (++count));
        //服务器回送数据
        ByteBuf responseByteBuf = Unpooled.copiedBuffer(UUID.randomUUID().toString() + " ", StandardCharsets.UTF_8);
        ctx.writeAndFlush(responseByteBuf);
    }
}
