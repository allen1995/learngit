package com.allen.dayup.java8.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;

/**
 * @Auther: allen
 * @Date: 2020-09-28 22:09
 * @Description:
 */
public class SelectorClientDemo {

    public static void main(String[] args) {

        //初始化客户端Channel
        try(SocketChannel socketChannel = SocketChannel.open() ) {
            //设置为非阻塞
            socketChannel.configureBlocking(false);

            //连接服务器
            socketChannel.connect(new InetSocketAddress(8080));

            while ( !socketChannel.finishConnect() ){
                System.out.println("等待连接到达。。。");
            }

            ByteBuffer buffer = ByteBuffer.allocate(8);

            while ( socketChannel.read(buffer) != -1 ){
                buffer.flip();

                while ( buffer.hasRemaining() ){

                    System.out.print( new Date(buffer.getLong()));
                }
                buffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
