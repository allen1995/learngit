package com.allen.dayup.thinkinjava.chap15;

/**
 * @Auther: 20190598
 * @Date: 2019/11/18 14:58
 * @Description:
 */
public class BasicHolder<T> {

    T element;

    public void set(T element){
        this.element = element;
    }

    public T get(){
        return element;
    }

    public void f(){
        System.out.println(element.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        Subtype st1 = new Subtype(), st2 = new Subtype();
        st1.set(st2);
        Subtype st3 = st1.get();
        st1.f();
    }

}

class Subtype extends BasicHolder<Subtype>{}


