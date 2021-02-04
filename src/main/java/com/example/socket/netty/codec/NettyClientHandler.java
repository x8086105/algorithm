package com.example.socket.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class NettyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private int count;


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for(int i = 0; i< 5; i++) {
            String mes = "今天天气冷，吃火锅" + i;
            byte[] content = mes.getBytes(Charset.forName("utf-8"));
            int length = mes.getBytes(Charset.forName("utf-8")).length;

            //创建协议包对象
//            MessageProtocol messageProtocol = new MessageProtocol();
//            messageProtocol.setLen(length);
//            messageProtocol.setContent(content);
            System.out.println("客户端发送消息：" + mes);
            ByteBuf buf = Unpooled.copiedBuffer(mes, StandardCharsets.UTF_8);
            ctx.writeAndFlush(buf);

        }

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] buffer = new byte[msg.readableBytes()];
        msg.readBytes(buffer);

        String message = new String(buffer, Charset.forName("utf-8"));
        System.out.println("客户端接收到消息=" + message);
        System.out.println("客户端接收消息数量=" + (++this.count));
    }
}
