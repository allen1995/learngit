package com.allen.dayup.deepredis.apply4;

import redis.clients.jedis.Jedis;

/**
 * @Auther: 20190598
 * @Date: 2020/4/2 16:06
 * @Description:
 */
public class PfTest {

    public static void main(String[] args) {

        Jedis jedis = new Jedis();
        for (int i = 0; i < 1000; i++) {
            jedis.pfadd("codeholder", "user_"+ i);

            long count = jedis.pfcount("codeholder");
            if( i+1 != count ){
                System.out.printf("total:%d,pfcount:%d\n", i+1, count);
                break;
            }
        }
    }
}
