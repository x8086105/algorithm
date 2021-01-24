package com.example.socket.mutileChat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LoggingHandler;

/**
 * 使用netty实现的服务端
 */
public class NettyServer {


    public void bind(int port) {
        //配置服务端NIO线程组
        /**
         * 说明：
         *  创建两个线程组，bossGroup和workGroup
         * bossGroup只用来负责处理连接，workGroup用来处理真正的客户端业务
         * 3.两个都是无限循环的
         * 4.bossGroup和 workerGroup含有的子线程NioEventLoop的个数，
         * 默认实际cpu核数*2
         * 当前纸条机器是12核 然后这个线程数应该是24个
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup(8);
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            //创建服务端启动对象
            ServerBootstrap b = new ServerBootstrap();
            //对服务端进行设置
            //设置两个线程组
            b.group(bossGroup, workGroup)
                    //使用NIOServerSocketChannel作为服务器的通道实现
                    .channel(NioServerSocketChannel.class)
                    //设置线程队列等待链接个数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //设置保持活动链接状态
                    .childOption(ChannelOption.SO_KEEPALIVE,Boolean.TRUE)
                    //针对的是bossGroup线程组 主要是应答连接的处理
                    //.handler(new LoggingHandler())
                    //针对的是workGroup线程组 主要是完成请求后的处理请求逻辑
                    //创建一个通道对象
                    .childHandler(new ChildChannelHandler());
            //绑定端口，同步等待成功
            ChannelFuture f = b.bind(port).sync();

            System.out.println("服务端OK....");
            //等待服务端监听端口关闭
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //优雅的退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        /**
         * 给pipeline设置处理器
         * @param socketChannel
         * @throws Exception
         */
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
//            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
//            socketChannel.pipeline().addLast(new StringDecoder());
            //给pipeline设置处理器
            System.out.println("客户socketchannel hashcode=" + socketChannel.hashCode());
            socketChannel.pipeline().addLast(new NettyServerHandler());
        }
    }

    public static void main(String[] args) {
        int port = 6668;
        if(args != null && args.length > 0){
            port = Integer.parseInt(args[0]);
        }
        new NettyServer().bind(port);
    }
}
