package com.example.basic.nettyNew;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.ssl.SslHandshakeCompletionEvent;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Sharable
public class ServerHandlerAdapter extends ChannelInboundHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        String ACCT = getACCTByChannel(ctx.channel());
        System.out.println("==========channel hashcode:" +ctx.channel().hashCode());
//        NettyServerListener.map.remove(ACCT);
        System.out.println("==========device" + ACCT + "异常 已断开 ");
//        clientRmiDevice.NettyAlarmNotify(ACCT+"13C7001");
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("==========device 发送注册包");
        ctx.writeAndFlush(Unpooled.copiedBuffer(registerByte()));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    /**
     * 心跳检测的超时时会触发
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        String ACCT = getACCTByChannel(ctx.channel());
        System.out.println("==========device" + ACCT + " 超时 ");
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            if (e.state() == IdleState.READER_IDLE) {  //读取心跳超时后，会将此channel连接断开

                ctx.close();  //如果超时，关闭这个通道
            }
        } else if (evt instanceof SslHandshakeCompletionEvent) {
            System.out.println("ssl handshake done");
            //super.userEventTriggered(ctx,evt);
        }
    }

    /**
     * 将 byte 数组转化为十六进制字符串
     *
     * @param bytes byte[] 数组
     * @param begin 起始位置
     * @param end   结束位置
     * @return byte 数组的十六进制字符串表示
     */
    public static String bytesToHex(byte[] bytes, int begin, int end) {
        StringBuilder hexBuilder = new StringBuilder(2 * (end - begin));
        for (int i = begin; i < end; i++) {
            hexBuilder.append(Character.forDigit((bytes[i] & 0xF0) >> 4, 16)); // 转化高四位
            hexBuilder.append(Character.forDigit((bytes[i] & 0x0F), 16)); // 转化低四位
        }
        return hexBuilder.toString().toUpperCase();
    }

    /**
     * 处理注册回发包（截取秘钥）
     * @param keyBytes
     * @return
     */
    private String decodeKey(byte[] keyBytes) {
        int[] dataFormat=new int[32];
        for(int i=0;i<keyBytes.length;i++) {
            if (keyBytes[i] < 0) {
                dataFormat[i] = keyBytes[i] & 0xff;
            } else {
                dataFormat[i] = keyBytes[i];
            }
        }
        return String.valueOf(new char[]{(char) dataFormat[15]
                ,(char) dataFormat[14]
                ,(char) dataFormat[13]
                ,(char) dataFormat[12]
                ,(char) dataFormat[11]
                ,(char) dataFormat[10]
                ,(char) dataFormat[9]
                ,(char) dataFormat[8]
                ,(char) dataFormat[23]
                ,(char) dataFormat[22]
                ,(char) dataFormat[21]
                ,(char) dataFormat[20]
                ,(char) dataFormat[19]
                ,(char) dataFormat[18]
                ,(char) dataFormat[17]
                ,(char) dataFormat[16]});
    }

    /**
     * 处理设备发来的数据
     * @param data
     */
    private void HandleData(byte[] data, ChannelHandlerContext ctx) {
        if (data == null || data[0] != -30) {
            return ;
        }
    }

    /**
     * 解析报警报数据
     * @param data
     * @return
     */
    private String decodeAlarm(byte[] data) {
        int[] dataFormat=new int[32];
        for(int i=0;i<data.length;i++) {
            if (data[i] < 0) {
                dataFormat[i] = data[i] & 0xff;
            } else {
                dataFormat[i] = data[i];
            }
        }
        String s = String.valueOf(new char[]{
                (char) dataFormat[4]                    //A
                ,(char) dataFormat[5]                   //C
                ,(char) dataFormat[6]                   //C
                ,(char) dataFormat[7]                   //T
                ,(char) dataFormat[10]                  //Q(1为新事件，3位恢复事件)
                ,(char) dataFormat[11]                  //E
                ,(char) dataFormat[12]                  //E
                ,(char) dataFormat[13]                  //E
                ,(char) dataFormat[16]                  //C
                ,(char) dataFormat[17]                  //C
                ,(char) dataFormat[18]});               //C
        return s;

    }

    /**
     * 发送注册包
     *
     * @return
     */
    private byte[] registerByte() {
        byte[] bytes = new byte[16];
        bytes[0] = (byte) 0xe1;
        bytes[1] = (byte) 0x01;
        bytes[2] = (byte) 0x04;
        bytes[3] = (byte) 0x10;
        for (int j = 4; j <= 15; j++) {
            bytes[j] = (byte) 0x00;
        }
        return bytes;
    }

    private String getACCTByChannel(Channel channel) {
        for (Map.Entry<String, Channel> entry : NettyServerListener.map.entrySet()) {
            if (channel.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return "";
    }

}
