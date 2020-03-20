//package com.allen.dayup.deepredis.apply3;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.TypeReference;
//import redis.clients.jedis.Jedis;
//
//import java.lang.reflect.Type;
//import java.util.Set;
//import java.util.UUID;
//
///**
// * @Auther: allen
// * @Date: 2020-02-27 11:55
// * @Description:
// */
//public class RedisDelayQueue<T> {
//
//    static class TaskItem<T>{
//        public String id;
//        public T msg;
//    }
//
//    private Type taskType = new TypeReference<TaskItem<T>>(){}.getType();
//    private Jedis jedis;
//    private String queueKey;
//
//    public RedisDelayQueue(Jedis jedis, String queueKey) {
//        this.jedis = jedis;
//        this.queueKey = queueKey;
//    }
//
//    public void delay(String msg){
//
//        TaskItem<String> taskItem = new TaskItem<>();
//        taskItem.id = UUID.randomUUID().toString();
//        taskItem.msg = msg;
//
//        String task = JSON.toJSONString(taskItem);
//        jedis.zadd(queueKey, System.currentTimeMillis() + 5000, task);
//    }
//
//    public void loop(){
//        while ( !Thread.interrupted() ){
//            Set<String> values = jedis.zrangeByScore(queueKey,0, System.currentTimeMillis(),0, 1);
//            if( values.isEmpty() ){
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    break;
//                }
//
//                continue;
//            }
//
//            String task = values.iterator().next();
//            if(jedis.zrem(queueKey, task) > 0 ){
//                TaskItem<String> item = JSON.parseObject(task, taskType);
//                this.handleMsg(item.msg);
//            }
//        }
//    }
//
//    private void handleMsg(String msg) {
//        System.out.println(msg);
//    }
//
//    public static void main(String[] args) {
//        Jedis jedis = new Jedis("172.16.15.105");
//        RedisDelayQueue<String> delayQueue = new RedisDelayQueue<>(jedis, "q-demo");
//
//        Thread producer = new Thread(){
//
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    delayQueue.delay("task" + i);
//                }
//            }
//        };
//
//        Thread consumer = new Thread(){
//
//            @Override
//            public void run() {
//                if(!Thread.interrupted()){
//                    delayQueue.loop();
//                }
//            }
//        };
//
//        producer.start();
//        consumer.start();
//
//        try {
//            producer.join();
//            Thread.sleep(6000);
//            consumer.interrupt();
//            consumer.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
