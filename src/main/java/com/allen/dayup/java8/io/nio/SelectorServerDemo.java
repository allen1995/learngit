package com.allen.dayup.java8.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Auther: allen
 * @Date: 2020-09-28 21:55
 * @Description:
 */
public class SelectorServerDemo {

    public static void main(String[] args) {

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

            //绑定服务器地址
            serverSocketChannel.bind(new InetSocketAddress(8080));

            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);

            System.out.println("当前服务器地址：" + serverSocketChannel.getLocalAddress());

            //打开Selector
            Selector selector = Selector.open();

            //注册OP_ACCEPT
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true){
                int n = selector.select();

                if( n == 0 ){
                    continue;
                }

                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();

                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();

                    if( key.isAcceptable() ){
                        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();

                        SocketChannel socketChannel = ssc.accept();
                        if( socketChannel == null ){
                            continue;
                        }

                        System.out.printf("接受客户端【%s】的请求...", socketChannel.getRemoteAddress());

                        ByteBuffer buffer = ByteBuffer.allocate(8);
                        //将当前服务器端的时间传递给客户端
                        buffer.putLong(System.currentTimeMillis());

                        buffer.flip();
                        while (buffer.hasRemaining()){
                            socketChannel.write(buffer);
                        }

                        socketChannel.close();
                        System.out.println("当前的时间已经发送给了客户端");
                    }

                    iterator.remove();
                }
            }

        } catch (ClosedChannelException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
