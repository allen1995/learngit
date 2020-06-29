package com.allen.dayup.arithmetic;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/1/9 09:42
 * @Description:
 */
public class test {

    public static void main(String[] args) throws IOException {
        //System.out.println(UUID.randomUUID().toString().replaceAll("-",""));

        //int a = 0;
        //count(a);
        //System.out.println(a);

        //System.out.println(LocalDateTime.now().toString());
        String myvalue = "[\n" +
                "\t{\n" +
                "\t\t\"userid\":\"50e8op178ef3fafb410c58dca84f1d179a464083\",\n" +
                "\t\t\"iotid\":\"test\",\n" +
                "\t\t\"mainid\":8,\n" +
                "\t\t\"triggeriotid\":\"DhCMIlZ8vVy6lSfwbRtO001006d400\",\n" +
                "\t\t\"templateid\":2\n" +
                "\t},\n" +
                "\t\n" +
                "\t{\n" +
                "\t\t\"userid\":\"50e8op178ef3fafb410c58dca84f1d179a464083\",\n" +
                "\t\t\"iotid\":\"test\",\n" +
                "\t\t\"mainid\":8,\n" +
                "\t\t\"triggeriotid\":\"tLyIqq3I30wwCtVKccvc000100\",\n" +
                "\t\t\"templateid\":2\n" +
                "\t}\n" +
                "]";

        ObjectMapper mapper = new ObjectMapper();
        JavaType jt = mapper.getTypeFactory().constructParametricType(ArrayList.class, AppSimplegatewayTriggerdeviceVo.class);
        List<AppSimplegatewayTriggerdeviceVo> triggerdeviceVos = mapper.readValue(myvalue, jt);
        System.out.println(triggerdeviceVos);
    }

    private static void count(int a){
        a++;
    }
}
