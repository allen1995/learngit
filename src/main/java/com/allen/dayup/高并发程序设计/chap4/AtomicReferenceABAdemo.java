package com.allen.dayup.高并发程序设计.chap4;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Auther: allen
 * @Date: 2020-03-30 18:02
 * @Description:
 */
public class AtomicReferenceABAdemo {

    static AtomicReference<Integer> money = new AtomicReference<>();

    public static void main(String[] args) {
        money.set(19);

        for (int i = 0; i < 3; i++) {
            new Thread(){
                @Override
                public void run() {
                    while (true){
                        while (true){
                            Integer m = money.get();
                            if( m < 20 ){
                                if( money.compareAndSet(m, m+20)){
                                    System.out.println("余额小于20元，充值成功！剩余余额：" + money.get());
                                    break;
                                } else {
                                    System.out.println("余额大于20元，无需充值！");
                                }
                            }
                        }
                    }
                }

            }.start();
        }


        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true){
                        Integer m = money.get();
                        if( m > 10 ){
                            if( money.compareAndSet(m, m-10)){
                                System.out.println("余额大于10元，消费成功！剩余余额：" + money.get());
                                break;
                            } else {
                                System.out.println("余额小于10元，无法消费！");
                            }
                        }
                    }
                }

            }
        }.start();



    }
}
