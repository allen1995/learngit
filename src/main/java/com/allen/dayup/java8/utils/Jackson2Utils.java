package com.allen.dayup.java8.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 20190598
 * @Date: 2020/6/2 10:37
 * @Description:
 */
public class Jackson2Utils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String converObjectToJson(Object obj) throws IOException {
        return objectMapper.writeValueAsString(obj);
    }

    public static    Map<String,Object>  converJsonToMap(String json) throws IOException{
        return objectMapper.readValue(json, HashMap.class);
    }

    public static  <V>  Map<String,V>  converJsonToMap(String json,Class<V> valueClass) throws IOException{
        JavaType jt = objectMapper.getTypeFactory().constructParametricType(HashMap.class,String.class,valueClass);

        return objectMapper.readValue(json, jt);
    }

    public static  <K,V>  Map<K,V>  converJsonToMap(String json,Class<K> keyClass,Class<V> valueClass) throws IOException{
        JavaType jt = objectMapper.getTypeFactory().constructParametricType(HashMap.class,String.class,keyClass,valueClass);

        return objectMapper.readValue(json, jt);
    }


    public static List<Object> coverJsonToList(String json) throws IOException{
        return objectMapper.readValue(json, List.class);
    }

    public static <T> List<T> converJsonToList(String json, Class<T> targetClass) throws IOException{
        JavaType jt = objectMapper.getTypeFactory().constructParametricType(List.class,targetClass);
        return objectMapper.readValue(json, jt);
    }


}
