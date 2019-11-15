package com.allen.dayup.thinkinjava.chap15;

/**
 * @Auther: 20190598
 * @Date: 2019/11/15 10:10
 * @Description: 演示泛型边界
 */
public class GenericBoundDemo {

    public static <T extends note> void note(T t){
        t.takeNote();
    }

    public static <B extends computer> void play(B b){
        b.playGame();
    }

    public static void main(String[] args) {
        Person person = new Person();
        note(person);
        play(person);
    }
}

interface note {
    void takeNote();
}

interface computer{
    void playGame();
}

class Person implements note, computer{

    @Override
    public void takeNote() {
        System.out.println("take note.");
    }

    @Override
    public void playGame() {
        System.out.println("play game.");
    }
}