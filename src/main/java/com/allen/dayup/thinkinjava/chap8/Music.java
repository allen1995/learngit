package com.allen.dayup.thinkinjava.chap8;

/**
 * @Auther: 20190598
 * @Date: 2019/10/21 11:45
 * @Description:
 */
public class Music {

    public static void main(String[] args) {
        Music music = new SonMusic();
        music.singWhat();
        //System.out.println(((SonMusic) music).filed);
    }

    public int field = 0;

    public static void singWhat(){
        what();
    }

    protected static void what(){
        System.out.println("Music.what()");
    }
}

class SonMusic extends Music{
    public int filed = 1;


    protected static void what() {
        System.out.println("SonMusic.what()");
    }
}
