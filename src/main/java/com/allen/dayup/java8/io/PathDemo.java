package com.allen.dayup.java8.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

/**
 * @Auther: 20190598
 * @Date: 2019/12/24 11:01
 * @Description:
 */
public class PathDemo {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:\\Test.txt");
        Path path1 = Paths.get("E:/teatcopy1.txt");
        Files.copy(path, path1, StandardCopyOption.COPY_ATTRIBUTES);
    }

    public static void iterateDir() throws IOException {
        Path path = Paths.get("E:/");
        DirectoryStream<Path> stream = Files.newDirectoryStream(path);
        for( Path e : stream ){
            System.out.println(e.getFileName());
        }
    }

    public static void fileRead() throws IOException {
        Path path = Paths.get("E:/test1.txt");
        Path path1 = FileSystems.getDefault().getPath("E:/", "text1.txt");

        if( !Files.exists(path)){
            Files.createFile(path);
        }

        BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);

        String line = "";
        while ( (line = reader.readLine()) != null ){
            System.out.println(line);
        }
    }
}
