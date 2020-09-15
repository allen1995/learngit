package com.allen.dayup.java8.io.stream;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @Auther: allen
 * @Date: 2020-09-14 23:16
 * @Description:
 */
public class DataOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        DataOutputStream outputStream = new DataOutputStream(System.out);

        outputStream.writeByte(65);
        outputStream.writeByte(97);

        outputStream.writeUTF("Hello,world");
        outputStream.flush();
        outputStream.close();
    }
}
