package com.example.basic.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Author: YinJiaqi
 * Date: 4/26/2020 10:42 AM
 * Content:
 */
public class HelloNettyServer {
    public static void main(String[] args){
        /**
         * 定义一对线程组（两个线程池）
         *
         */
        //主线程组，用于接收客户端的链接，但不做任何处理
        EventLoopGroup bossGroup  = new NioEventLoopGroup();
        //定义从线程组，主线程组会把任务转给从线程组进行处理
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workerGroup).option(ChannelOption.SO_BACKLOG, 128).
                channel(NioServerSocketChannel.class).childHandler(new HelloNettyServerInitializer());
        ChannelFuture future = serverBootstrap.bind(8888).sync();
            /**
             * 关闭
             */
            //获取某个客户端所对应的chanel，关闭并设置同步方式
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //使用一种优雅的方式进行关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
