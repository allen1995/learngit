package com.allen.dayup.thinkinjava.chap9;

/**
 * @Auther: 20190598
 * @Date: 2019/10/23 11:14
 * @Description:
 */
public class test4 {
    public static void main(String[] args) {

    }
}


abstract class Father{

}

class bigSon extends Father{
    public static void g(Father father){
        ((bigSon) father).g(new Father() {
        });
    }

    public static void main(String[] args) {
        bigSon.g(new Father() {
        });
    }
}

