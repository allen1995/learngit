package com.allen.dayup.java8.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther: allen
 * @Date: 2020-04-06 13:44
 * @Description:
 */
public class GetResourceAsStreamDemo {

    public static void main(String[] args) throws IOException {
        try(InputStream inputStream = GetResourceAsStreamDemo.class.getResourceAsStream("/default.properties")){

            Properties props = new Properties();
            props.load(inputStream);
            System.out.println(props.getProperty("name"));
        }


    }


}
