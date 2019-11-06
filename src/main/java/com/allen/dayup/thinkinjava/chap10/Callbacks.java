package com.allen.dayup.thinkinjava.chap10;

/**
 * @Auther: 20190598
 * @Date: 2019/10/28 17:21
 * @Description:
 */
public class Callbacks {
}


interface Incrementable {
    void increment();
}

class caller1 implements Incrementable{

    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}


class MyIncrement{
    public  void increment(){
        System.out.println("Other operation..");

    }

    static void f(MyIncrement mi){
        mi.increment();
    }


}