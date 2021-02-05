package com.example.basic.nettyNew;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;


@Component
public class NettyServerListener {


    public static Map<String, Channel> map = new ConcurrentHashMap<String, Channel>();
    public static Map<String, String> keyMap= new ConcurrentHashMap<String, String>();

    @Resource
    private ServerHandlerAdapter serverHandlerAdapter;

    NioEventLoopGroup boss = new NioEventLoopGroup();
    NioEventLoopGroup worker = new NioEventLoopGroup();

    /**
     * 关闭服务器方法
     */
    @PreDestroy
    public void close() {
        //优雅退出
        System.out.println("关闭服务器....");
        boss.shutdownGracefully();
        worker.shutdownGracefully();
    }

    public void start() {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new IdleStateHandler(300, 0, 0, TimeUnit.SECONDS));
                        socketChannel.pipeline().addLast(new ByteArrayDecoder());
                        socketChannel.pipeline().addLast(new ByteArrayEncoder());
                        socketChannel.pipeline().addLast(serverHandlerAdapter);
                    }
                });
        try {
            ChannelFuture f = serverBootstrap.bind(8888).sync();
            System.out.println("======device 正在监听端口8888");
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        new NettyServerListener().start();
    }
}
