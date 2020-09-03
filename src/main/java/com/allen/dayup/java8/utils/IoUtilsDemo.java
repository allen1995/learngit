package com.allen.dayup.java8.utils;

import com.allen.dayup.thinkinjava.chap15.FilledListMaker;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2019/12/24 09:49
 * @Description:
 */
public class IoUtilsDemo {

    public static void main(String[] args) throws IOException {

        //流读取操作
        //InputStream is = new URL("https://www.baidu.com").openStream();
        //
        //try {
        //    System.out.println(IOUtils.toString(is, "utf-8"));
        //
        //    List<String> list = IOUtils.readLines(is, "utf-8");
        //    list.stream().forEach(System.out::println);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}finally {
        //    IOUtils.closeQuietly(is);
        //}

        File file = new File("E:/Test.txt");
        List<String> lines = FileUtils.readLines(file, "utf-8");
        lines.stream().forEach(System.out::println);

        byte[] fileBytes = FileUtils.readFileToByteArray(file);
        FileUtils.writeByteArrayToFile(new File("E:/testcopy.txt"), fileBytes);
        FileUtils.writeStringToFile(new File("E:/textmy.txt"), "Test");
    }


}
