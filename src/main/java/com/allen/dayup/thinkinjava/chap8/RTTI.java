package com.allen.dayup.thinkinjava.chap8;

/**
 * @Auther: 20190598
 * @Date: 2019/10/23 10:16
 * @Description:
 */
public class RTTI {

    public static void main(String[] args) {
        Useful[] usefuls = { new Useful(), new MoreUseful()};
        usefuls[0].f();
        usefuls[1].g();

        ((MoreUseful)usefuls[1]).u();
        ((MoreUseful)usefuls[0]).u();
    }


}

class Useful{

    public void f(){
        System.out.println("Useful.f()");
    }

    public void g(){
        System.out.println("Useful.f()");
    }
}

class MoreUseful extends Useful{

    @Override
    public void f() {
        System.out.println("MoreUseful.f()");
    }

    @Override
    public void g() {
        System.out.println("MoreUseful.g()");
    }

    public void u(){
        System.out.println("MoreUseful.u()");
    }
}
