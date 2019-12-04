package com.allen.dayup.thinkinjava.chap15;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Objects;

/**
 * @Auther: 20190598
 * @Date: 2019/11/15 10:41
 * @Description:
 */
public class GenericWildcardDemo {
    public static void main(String[] args) {
        //List<? extends Fruit> list = new ArrayList<>();
        //list.add(null);
        //System.out.println(list.get(0));
        Holder<Apple> apple = new Holder<Apple>(new Apple());
        Apple d  = apple.getValue();
        apple.setValue(d);

        Holder<? extends Fruit> fruit = apple;
        Fruit p = fruit.getValue();
        d = (Apple) fruit.getValue();

        try {
            Orange c = (Orange) fruit.getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(fruit.equals(d));
    }

}

class Holder<T> {

    private T value;
    public Holder(){}

    public Holder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        return value.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
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

