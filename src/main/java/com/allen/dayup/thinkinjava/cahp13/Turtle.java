package com.allen.dayup.thinkinjava.cahp13;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * @Auther: 20190598
 * @Date: 2019/11/6 13:41
 * @Description:
 */
public class Turtle {
    private String name;

    private Formatter formatter;

    public Turtle(String name, Formatter formatter) {
        this.name = name;
        this.formatter = formatter;
    }

    public void move(int x, int y){
        formatter.format("%s the trutle at the (%d, %d).\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.err;
        Turtle tommy = new Turtle("Tommy",new Formatter(outAlias));
        Turtle jerry = new Turtle("jerry", new Formatter(System.out));

        tommy.move(10,6);
        jerry.move(2,3);

    }
}
