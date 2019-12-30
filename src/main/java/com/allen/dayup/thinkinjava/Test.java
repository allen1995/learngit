package com.allen.dayup.thinkinjava;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.java2d.pipe.AAShapePipe;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: 20190598
 * @Date: 2019/12/5 11:09
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws IOException {
        //String now = "2007-12-03 10:15:30";
        //LocalDateTime localDateTime = LocalDateTime.parse(now, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //System.out.println(localDateTime);

        //ArrayList<A> doItemList = new ArrayList<A>();
        //doItemList.add(new A("b", 2));
        //doItemList.add(new A("a", 3));
        //doItemList.add(new A("老王", 3));
        //Map<String, A> map =  doItemList.stream().distinct().filter(x -> !x.getName().equals("老王")).collect(
        //        Collectors.toMap(A::getName, a -> a));
        //
        //map.forEach((key,value) -> {
        //    System.out.println("key:" + key + ",value:" + value);
        //});

        ObjectMapper objectMapper = new ObjectMapper();
        String s = "[\"a\",\"b\"]";
        JsonNode sArr = objectMapper.readTree(s);

        System.out.println(sArr.size());


    }
}
