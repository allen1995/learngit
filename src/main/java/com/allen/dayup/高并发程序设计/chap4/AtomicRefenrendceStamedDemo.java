package com.allen.dayup.高并发程序设计.chap4;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Auther: allen
 * @Date: 2020-03-30 18:14
 * @Description:
 */
public class AtomicRefenrendceStamedDemo {

    static AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19,0);

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            final Integer stamped = money.getStamp();
            new Thread(){
                @Override
                public void run() {
                    while (true){
                        while (true){
                            Integer m = money.getReference();
                            if( m < 20 ){
                                if( money.compareAndSet(m, m+20,stamped, stamped+1)){
                                    System.out.println("余额小于20元，充值成功！剩余余额：" + money.getReference());
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
                        Integer m = money.getReference();
                        Integer stamped = money.getStamp();
                        if( m > 10 ){
                            if( money.compareAndSet(m, m-10, stamped, stamped+1)){
                                System.out.println("余额大于10元，消费成功！剩余余额：" + money.getReference());
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
