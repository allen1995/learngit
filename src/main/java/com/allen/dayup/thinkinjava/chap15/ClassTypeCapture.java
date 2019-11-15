package com.allen.dayup.thinkinjava.chap15;

/**
 * @Auther: 20190598
 * @Date: 2019/11/13 15:36
 * @Description:
 */
public class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg){
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<House> ctt1 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt1.f(new House()));
        System.out.println(ctt1.f(new Building()));

        ClassTypeCapture<Building> ctt2 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt2.f(new House()));
        System.out.println(ctt2.f(new Building()));
    }
}


class Building{}

class House extends Building{}