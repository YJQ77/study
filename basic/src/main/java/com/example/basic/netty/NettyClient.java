package com.example.basic.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.AttributeKey;

/**
 * Author: YinJiaqi
 * Date: 9/3/2020 4:06 PM
 * Content:
 */
public class NettyClient {
    public static void main(String[] args){
        try {
            Bootstrap client  = new Bootstrap();
            EventLoopGroup group = new NioEventLoopGroup();
            client.group(group).channel(NioSocketChannel.class);
            //第3步 给NIoSocketChannel初始化handler， 处理读写事件
            client.handler(new ChannelInitializer<NioSocketChannel>() {  //通道是NioSocketChannel
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    //字符串编码器，一定要加在SimpleClientHandler 的上面
                    ch.pipeline().addLast(new StringEncoder());
                    ch.pipeline().addLast(new DelimiterBasedFrameDecoder(
                            Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
                    //找到他的管道 增加他的handler
                    ch.pipeline().addLast(new SimpleClientHandler());
                }
            });

            //连接服务器
            ChannelFuture future = client.connect("localhost", 8888).sync();
            //发送数据给服务器
            for(int i=0;i<5;i++){
                String msg = "ssss"+i+"\r\n";
                future.channel().writeAndFlush(msg);
            }

            //当通道关闭了，就继续往下走
            future.channel().closeFuture().sync();
            //接收服务端返回的数据
            AttributeKey<String> key = AttributeKey.valueOf("ServerData");
            Object result = future.channel().attr(key).get();
            System.out.println(result.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        }

    }
}
