package com.allen.dayup.deepredis.apply4;

import redis.clients.jedis.Jedis;

/**
 * @Auther: 20190598
 * @Date: 2020/4/2 16:13
 * @Description:
 */
public class PfCountTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis();

        for (int i = 0; i < 100000; i++) {
            jedis.pfadd("codehold","user_" + i);
        }

        long total = jedis.pfcount("codehold");
        System.out.printf("%d %d\n", 100000, total);
    }
}
