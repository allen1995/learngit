package com.allen.dayup.thinkinpattern.chap6.commandpattern;

/**
 * @Auther: 20190598
 * @Date: 2020/5/11 16:14
 * @Description:
 */
public class IAm implements Command {
    @Override
    public void execute() {
        System.out.println("I am command pattern!");
    }
}
