package com.allen.dayup.arithmetic;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: 20190598
 * @Date: 2020/1/9 09:42
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws IOException {
        //ObjectMapper mapper = new ObjectMapper();
        //String json = "{\"name\":\"\",\"age\":12}";
        //JsonNode jsonNode = mapper.readTree(json);
        //System.out.println(jsonNode.get("name").asText().isEmpty());
        //System.out.println(jsonNode.get("test"));

        //ObjectMapper mapper = new ObjectMapper();
        //String json = "{\"name\":\"allen\"}";
        //JsonNode node = mapper.readTree(json);
        //
        //System.out.println(mapper.readValue(node.toString(), HashMap.class));

        int starttimeInt = 2200;
        int endtimeInt = 800;
        int nowTimeInt = 900;

         boolean result = (starttimeInt < endtimeInt && (starttimeInt <= nowTimeInt && nowTimeInt <= endtimeInt)) || (starttimeInt > endtimeInt && (starttimeInt <= nowTimeInt || nowTimeInt <= endtimeInt));
        System.out.println(result);
    }



    private static void count(int a){
        a++;
    }
}
