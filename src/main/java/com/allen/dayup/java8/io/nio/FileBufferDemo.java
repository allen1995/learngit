package com.allen.dayup.java8.io.nio;

import sun.util.resources.cldr.ebu.CurrencyNames_ebu;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Auther: allen
 * @Date: 2020-09-29 23:15
 * @Description:
 */
public class FileBufferDemo {

    public static void main(String[] args) throws IOException {
        //获取工程路径
        String projectDir = System.getProperty("user.dir");
        Path path = Paths.get(projectDir + "/test.txt");

        //构建FileChannel
        FileChannel fileChannel = FileChannel.open(path);
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);

        //读取FileChannel里的内容
        while ( fileChannel.read(byteBuffer) != -1 ){
            byteBuffer.flip();

            while ( byteBuffer.hasRemaining() ){
                System.out.print( (char) byteBuffer.get());
            }

            byteBuffer.clear();
        }

    }
}
