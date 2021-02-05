package com.example.basic.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;

/**
 * Author: YinJiaqi
 * Date: 4/26/2020 1:38 PM
 * Content:
 */
public class HelloNettyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
       // pipeline.addLast("HttpServerCodec", new HttpServerCodec());
        pipeline.addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
        //添加自定义的CustomHandler这个handler，返回Hello Netty
      //  pipeline.addLast("customHandler", new CustomHandler());
         pipeline.addLast(new SimpleServerHandler());
    }
}
