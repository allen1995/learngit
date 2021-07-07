package com.allen.dayup.java8.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * @Auther: 20190598
 * @Date: 2021/7/2 10:35
 * @Description:
 */
public class GroupbyingTest {

    public static void main(String[] args) {
        List<Map<String,String>> users = new ArrayList<>();

        Map<String,String> user1 = new HashMap<>();
        user1.put("id", "1");
        user1.put("name", "爸爸");
        user1.put("fingername", "指纹1");
        user1.put("type", "1");
        users.add(user1);

        Map<String,String> user2 = new HashMap<>();
        user2.put("id", "1");
        user2.put("name", "爸爸");
        user2.put("fingername", "密码1");
        user2.put("type", "2");
        users.add(user2);

        Map<String,String> user3 = new HashMap<>();
        user3.put("id", "2");
        user3.put("name", "妈妈");
        user3.put("fingername", "指纹1");
        user3.put("type", "1");
        users.add(user3);

        Map<String,String> user4 = new HashMap<>();
        user4.put("id", "2");
        user4.put("name", "妈妈");
        user4.put("fingername", "指纹2");
        user4.put("type","2");
        users.add(user4);

        Map<String,List<Map<String,String>>> groupList = users.stream()
                .collect(groupingBy(user -> {
                    return user.get("name") + user.get("type");
                }));

        System.out.println(groupList);

        //Map<Map<String,String>, String> result =
        //         users
        //        .stream()
        //        .collect(Collectors.groupingBy(GroupbyingTest::getUser, Collectors.mapping(GroupbyingTest::getFingername, Collectors.joining(","))))
        //        ;
        //
        //List<Map<String,String>> data = new ArrayList<>();
        //result.forEach( (key,value) -> {
        //    Map<String,String> map = new HashMap<>();
        //    map.putAll(key);
        //    map.put("fingernames", value);
        //
        //    data.add(map);
        //});

        //System.out.println(data);
    }

    private static Map<String,String> getUser(Map<String,String> user) {
        Map<String,String> result = new HashMap<>();
        result.put("id", user.get("id"));
        result.put("name", user.get("name"));

        return result;
    }

    private static String getFingername(Map<String,String> user) {
        return user.get("fingername");
    }


}
