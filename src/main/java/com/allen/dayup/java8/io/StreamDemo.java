package com.allen.dayup.java8.io;

import java.io.*;

/**
 * @Auther: allen
 * @Date: 2020-04-06 11:01
 * @Description:
 */
public class StreamDemo {

    public static void main(String[] args) throws IOException {
        writeFileWithByte();
    }



    private static void writeFileWithByte() throws IOException {
        File file = new File(".\\readme.txt");
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write("HelloByte".getBytes());
        outputStream.close();
    }

    public static void writeFile() throws IOException {
        File file = new File(".\\readme.txt");
        System.out.println(file.getCanonicalPath());

        OutputStream output = new FileOutputStream(file);
        output.write(72); // H
        output.write(101); // e
        output.write(108); // l
        output.write(108); // l
        output.write(111); // o
        output.close();
    }

    /**
     * 读取文件
     * @throws IOException
     */
    private static void readFile() throws IOException {
        File file = new File("D:\\Test.txt");


        try (InputStream inputStream = new FileInputStream(file) ){
            int n;
            while ( (n = inputStream.read()) != -1 ){
                System.out.println(n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 利用buffer读取文件
     * @throws IOException
     */
    private static void readFileWithBuffer() throws IOException {
        File file = new File("D:\\Test.txt");
        byte[] buffer = new byte[1000];

        try (InputStream inputStream = new FileInputStream(file) ){
            int n;
            while ( (n = inputStream.read(buffer)) != -1 ){
                System.out.println(n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
