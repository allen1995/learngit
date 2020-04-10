package com.allen.dayup.deepredis.apply6;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

/**
 * @Auther: 20190598
 * @Date: 2020/4/7 10:11
 * @Description:
 */
public class SimpleLimiter {

    private Jedis jedis;

    public SimpleLimiter(Jedis jedis) {
        this.jedis = jedis;
    }

    /**
     * 是否允许用户访问
     * @param userId:用户ID
     * @param actionKey:动作类型
     * @param period:时间周期
     * @param maxCount:周期内允许的最大数量
     */
    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) throws InterruptedException {
        String key = String.format("hist:%s:%s", userId,actionKey);
        long nowTs = System.currentTimeMillis();

        Pipeline pipeline = jedis.pipelined();
        pipeline.multi();

        pipeline.zadd(key, nowTs, nowTs+"");
        pipeline.zremrangeByScore(key, 0 , nowTs-period*1000);

        Response<Long> count = pipeline.zcard(key);
        pipeline.expire(key, period+1);
        pipeline.exec();
        pipeline.close();


        //Transaction multi = jedis.multi();
        //Response<Long> count = null;
        //
        //try {
        //
        //    multi.zadd(key, nowTs, nowTs+"");
        //    //multi.zremrangeByScore(key, 0, nowTs-period*1000);
        //
        //    count = multi.zcard(key);
        //    //multi.expire(key, period+1);
        //} catch ( Exception e){
        //    System.out.println("exception.");
        //    multi.discard();
        //}
        //multi.exec();

        //jedis.zadd(key, nowTs, nowTs+"");
        //long count = jedis.zcard(key);
        //Thread.sleep(100);
        
        return count.get() <= maxCount;
    }

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis();

        SimpleLimiter limiter = new SimpleLimiter(jedis);

        for (int i = 0; i < 10; i++) {
            boolean allowed = limiter.isActionAllowed("allen", "reply", 60, 5);
            System.out.println(allowed);
        }


    }
}
