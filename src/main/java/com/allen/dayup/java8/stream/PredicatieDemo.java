package com.allen.dayup.java8.stream;

import java.io.File;
import java.util.function.Predicate;

/**
 * @Auther: allen
 * @Date: 2020-04-18 19:44
 * @Description:
 */
public class PredicatieDemo {

    public static void main(String[] args) {
        Predicate<File> perdicate = PredicatieDemo::isDir;
        System.out.println(perdicate.test(new File("D:\\text.txt")));
    }

    public static boolean isDir(File file){
        return file.isDirectory();
    }
}
