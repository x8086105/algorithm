package com.example.socket.mutileChat;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;
import io.netty.util.NettyRuntime;

import java.nio.charset.StandardCharsets;


public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    private int counter;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        //输出线程信息
        System.out.println("服务器读取的线程:" + Thread.currentThread().getName());
        System.out.println("server ctx = " + ctx);

        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发送消息是:" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址:" + ctx.channel().remoteAddress());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将数据写入到缓冲并刷新
        //一般来讲，对发送的数据进行一个编码，
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello Client:wang~", CharsetUtil.UTF_8));
    }

    /**
     * 处理异常，一般是关闭掉这个异常
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }

}
