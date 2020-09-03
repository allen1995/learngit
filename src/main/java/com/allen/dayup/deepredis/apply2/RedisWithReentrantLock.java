package com.allen.dayup.deepredis.apply2;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: allen
 * @Date: 2020-02-26 17:43
 * @Description:
 */
public class RedisWithReentrantLock {

    private ThreadLocal<Map> lockers = new ThreadLocal<>();
    private Jedis jedis;
    private static long REDIS_OPRATE_CODE = 1L;

    public RedisWithReentrantLock(Jedis jedis) {
        this.jedis = jedis;
    }

    public static void main(String[] args) {
        //Jedis jedis = new Jedis("172.16.15.105",6379);
        //RedisWithReentrantLock redisWithReentrantLock = new RedisWithReentrantLock(jedis);
        //System.out.println(jedis.del("Test"));
        Jedis jedis = new Jedis("172.16.15.105",6379);
        RedisWithReentrantLock reentrantLock = new RedisWithReentrantLock(jedis);

        System.out.println(reentrantLock.lock("codehole"));
        System.out.println(reentrantLock.lock("codehole"));
        System.out.println(reentrantLock.unlock("codehole"));
        System.out.println(reentrantLock.unlock("codehole"));

    }

    private boolean _lock(String key){
        boolean result = false;
        long lockFlag = jedis.setnx(key,"");
        if( lockFlag == REDIS_OPRATE_CODE){
            jedis.expire(key,10);
            result = true;
        }

        return result;
    }

    private boolean _unlock(String key){
        return jedis.del(key) != REDIS_OPRATE_CODE;
    }

    private Map<String,Integer> currentLockers(){
        Map<String,Integer> refs = lockers.get();
        if( refs != null ){
            return refs;
        }
        lockers.set(new HashMap());

        return lockers.get();
    }

    public boolean lock(String key){
        Map<String,Integer> refs = this.currentLockers();
        Integer refCnt = refs.get(key);

        if( refCnt != null ){
            refs.put(key, refCnt + 1 );
            return true;
        }

        boolean ok = this._lock(key);

        if( !ok ){
            return false;
        }

        refs.put(key,1);
        return true;
    }

    public boolean unlock(String key){
        Map<String,Integer> refs = this.currentLockers();
        Integer refCnt = refs.get(key);
        if( refCnt == null ){
            return false;
        }

        refCnt--;

        if( refCnt > 0 ){
            refs.put(key, refCnt);
        }else {
            refs.remove(key);
            this._unlock(key);
        }

        return true;
    }

}
