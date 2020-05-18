package com.allen.dayup.thinkinpattern.chap6.commandpattern;

/**
 * @Auther: 20190598
 * @Date: 2020/5/11 16:13
 * @Description:
 */
public class World implements Command {
    @Override
    public void execute() {
        System.out.println("World!");
    }
}
