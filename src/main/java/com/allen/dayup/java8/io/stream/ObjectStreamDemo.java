package com.allen.dayup.java8.io.stream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: allen
 * @Date: 2020-09-14 23:21
 * @Description:
 */
public class ObjectStreamDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<String> strings = new ArrayList<>(Arrays.asList("A,B,C"));

        File file = new File("strings.ser");

        //对象序列化
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(strings);
            objectOutputStream.flush();
        }

        //对象反序列化
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))){
            List<String> copyStrings = (List<String>) inputStream.readObject();
            System.out.println(copyStrings);
        }

    }
}
