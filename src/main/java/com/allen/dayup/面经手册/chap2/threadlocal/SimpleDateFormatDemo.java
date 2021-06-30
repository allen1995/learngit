package com.allen.dayup.面经手册.chap2.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: allen
 * @Date: 2021-06-30 22:28
 * @Description:
 */
public class SimpleDateFormatDemo {

    //线程安全
    private static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal
            .withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    //线程不安全
    //private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        while (true) {
            new Thread( () -> {
                String dateStr = threadLocal.get().format(new Date());

                try {
                    Date checkDate = threadLocal.get().parse(dateStr);
                    String checkDateStr = threadLocal.get().format(checkDate);

                    boolean check = checkDateStr.equals(dateStr);
                    if( !check ) {
                        System.out.println("dataStr:" + dateStr + ",checkDateStr:" + checkDateStr);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}
