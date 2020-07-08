package com.allen.dayup.java8.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @Auther: allen
 * @Date: 2020-04-06 10:36
 * @Description:
 */
public class FileDemo {

    public static void main(String[] args) throws IOException {

        //创建一个新的文件
        File file = new File("D:\\Test.txt");
        System.out.println(file);

        //创建文件
        System.out.println(file.createNewFile());

        //删除文件
        System.out.println(file.delete());

        File file1 = new File(".\\Test.txt");

        //文件路径
        File f = new File("..");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());

        //文件分隔符
        System.out.println(File.separator);

        //文件类型
        File f1 = new File("C:\\Windows");
        File f2 = new File("C:\\Windows\\notepad.exe");
        File f3 = new File("C:\\Windows\\nothing");
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());
        System.out.println(f3.isFile());
        System.out.println(f3.isDirectory());

        //遍历文件
        File f5 = new File("C:\\Windows");
        File[] files = f5.listFiles();

        printFiles( files);

        File[] files1 = f5.listFiles((dir,name) -> {
            return name.endsWith(".exe");
        });

        printFiles(files1);
    }

    private static void printFiles(File[] files) {

        System.out.println("==========================");
        if( files != null ){
            for( File file: files ){
                System.out.println(file.getName());
            }
        }

        System.out.println("=============================");
    }


}
