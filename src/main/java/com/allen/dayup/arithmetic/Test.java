package com.allen.dayup.arithmetic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Auther: 20190598
 * @Date: 2020/1/9 09:42
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"name\":\"\",\"age\":12}";
        JsonNode jsonNode = mapper.readTree(json);
        System.out.println(jsonNode.get("name").asText().isEmpty());
        System.out.println(jsonNode.get("test"));

    }

    private static void count(int a){
        a++;
    }
}
