package com.example.socket.mutileChat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 使用Netty实现的客户端
 */
public class NettyClient {

    public void connect(int port, String host) {
        //客户端只需要一个事件循环即可
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建客户端启动对象
            Bootstrap b = new Bootstrap();
            //设置线程组
            b.group(group)
                    //设置客户端通道的实现类
                    .channel(NioSocketChannel.class)
                    //
                    .handler(new ChannelInitializer<SocketChannel>() {
                        //加入自己的处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
//                            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
//                            socketChannel.pipeline().addLast(new StringDecoder());
                            socketChannel.pipeline().addLast(new NettyClientHandler());
                        }
                    });
            //关于ChannelFuture的分析，涉及到netty的异步模型
            ChannelFuture f = b.connect(host, port).sync();

            System.out.println("客户端 ok...");
            //给关闭通道进行监听
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port = 6668;
        String host = "127.0.0.1";
        new NettyClient().connect(port, host);
    }
}
