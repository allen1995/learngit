package com.allen.dayup.java8.io.stream;

import java.io.IOException;

/**
 * @Auther: allen
 * @Date: 2020-09-14 23:13
 * @Description:
 */
public class CommandLineDemo {

    public static void main(String[] args) throws IOException {
        System.out.println("请输入任意内容结束...");

        System.in.read();
    }
}
