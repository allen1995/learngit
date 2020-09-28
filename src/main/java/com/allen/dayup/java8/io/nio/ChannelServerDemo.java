package com.allen.dayup.java8.io.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Auther: allen
 * @Date: 2020-09-28 21:35
 * @Description:
 */
public class ChannelServerDemo {

    //select 和 epoll
    public static void main(String[] args) throws IOException, InterruptedException {

        //服务器端SocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8080));

        //设置为非组赛
        serverSocketChannel.configureBlocking(false);

        System.out.println("当前服务器地址：" + serverSocketChannel.getLocalAddress());

        String message = "Hello, World!";
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());

        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();

            if( socketChannel != null ){
                System.out.printf("接受客户端【%s】的连接...", socketChannel.getRemoteAddress());
                buffer.rewind();
                socketChannel.write(buffer); //写入buffer到管道中
                socketChannel.close();
            }else {
                Thread.sleep(500);
            }
        }
    }
}
