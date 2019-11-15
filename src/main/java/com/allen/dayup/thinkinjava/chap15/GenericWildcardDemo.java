package com.allen.dayup.thinkinjava.chap15;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2019/11/15 10:41
 * @Description:
 */
public class GenericWildcardDemo {
    public static void main(String[] args) {
        List<? extends Fruit> list = new ArrayList<>();
        list.add(null);
        System.out.println(list.get(0));
    }

}


class Fruit{
    public void nutrition(){
        System.out.println("nutrition");
    }
}

class Apple extends Fruit{

    public void extraApple(){
        System.out.println("extraApple.");
    }
}
class Orange extends Fruit{

    public void extraOrange(){
        System.out.println("extraOrange.");
    }
}

