package com.allen.dayup.java8.io;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @Auther: allen
 * @Date: 2020-04-06 17:08
 * @Description:
 */
public class DatagramSocketClient {

    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        ds.setSoTimeout(1000);
        ds.connect(InetAddress.getByName("localhost"),7777);
        //发送
        byte[] data = "Hello,Server!".getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket(data, data.length);
        ds.send(packet);

        //接收
        byte[] buffer = new byte[1024];
        packet = new DatagramPacket(buffer,buffer.length);
        ds.receive(packet);
        String resp = new String(packet.getData(),packet.getOffset(),packet.getLength(),StandardCharsets.UTF_8);
        System.out.println("客户端接受到响应:" + resp);
        ds.disconnect();
    }
}
