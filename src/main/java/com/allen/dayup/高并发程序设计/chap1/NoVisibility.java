package com.allen.dayup.高并发程序设计.chap1;

/**
 * @Auther: allen
 * @Date: 2020-03-19 22:15
 * @Description:
 */
public class NoVisibility {
    //当ready为非volatile变量时，程序不能正常退出，因为reader线程不能看到主线程对变量的修改
    private static volatile boolean ready = false;
    private static int number;

    private static class Reader extends Thread{

        @Override
        public void run() {
            while ( !ready ){

            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Reader reader = new Reader();
        reader.start();
        number = 42;
        ready = true;
    }
}
