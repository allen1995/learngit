package com.allen.dayup.arithmetic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @Auther: 20190598
 * @Date: 2020/1/9 09:42
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws IOException {
        double ans1=0;
        for (int i = 0; i < 4000000; i++){
            ans1 += 0.1;
        }
        System.out.printf("%f\n", ans1);  //399999.999979,如果换成float类型呢？
        

        System.out.println(0.1000001f);

    }

    private static void count(int a){
        a++;
    }
}
