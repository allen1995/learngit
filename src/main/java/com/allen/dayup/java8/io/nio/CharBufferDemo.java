package com.allen.dayup.java8.io.nio;

import javax.sound.midi.SoundbankResource;
import java.nio.CharBuffer;

/**
 * @Auther: allen
 * @Date: 2020-09-26 21:33
 * @Description:
 */
public class CharBufferDemo {

    public static void main(String[] args) {

        CharBuffer charBuffer = CharBuffer.allocate(8);
        // mark[-1] position[0] limit[8] capacity[8]

        //当内容小于8字节
        String message = "Hello";

        for( char c : message.toCharArray()){
            charBuffer.put(c);
        }

        // mark[-1] position[5] limit[8] capacity[8]
        displayByteBufferMetadata(charBuffer);

        // position -> 0, limit: 8 -> 5
        charBuffer.flip();

        displayByteBufferMetadata(charBuffer);

        while ( charBuffer.hasRemaining() ){
            System.out.print(charBuffer.get());
        }

        System.out.println();
        displayByteBufferMetadata(charBuffer);
    }


    public static void displayByteBufferMetadata(CharBuffer byteBuffer) {
        System.out.printf("当前 Buffer[type %s], position：%d, limit: %d, capacity:%d \n",
                byteBuffer.getClass().getName(), byteBuffer.position(), byteBuffer.limit(),
                byteBuffer.capacity());

    }
}
