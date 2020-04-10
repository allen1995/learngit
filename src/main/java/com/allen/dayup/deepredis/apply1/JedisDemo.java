package com.allen.dayup.deepredis.apply1;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: allen
 * @Date: 2020-02-24 11:00
 * @Description:
 */
public class    JedisDemo {
    static Jedis jedis;

    static {
        jedis = new Jedis("172.16.15.105", 6379);
    }

    public static void main(String[] args) {
        hset();
    }

    private static void hset(){
        //User lisi = new User("lisi",21);
        try {
            Map<String,String> user = new HashMap<>();
            user.put("name","lisi");
            user.put("age","18");
            jedis.hmset("lisi", user);
            System.out.println(jedis.hget("lisi","name"));
        } finally {
            jedis.close();
        }
    }

    private static void set(){
        try {
            User zhangsan = new User("zhangsan",15);
            String zhangsanStr = JSON.toJSONString(zhangsan);
            jedis.set("zhangsan",zhangsanStr);
        } finally {
            jedis.close();
        }
    }

    private static void get(){
        try {
            String zhangsanStr = jedis.get("zhangsan");
            User user = JSON.parseObject(zhangsanStr, User.class);
            System.out.println(user);
        } finally {
            jedis.close();
        }
    }

}
