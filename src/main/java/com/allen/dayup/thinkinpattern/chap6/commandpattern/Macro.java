package com.allen.dayup.thinkinpattern.chap6.commandpattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/5/11 16:15
 * @Description: 工厂模式要点：处理器内部定义一个指令集合，外部可以传入指定集合，提供一个run方法给外部运行指令
 */
public class Macro {

    private List<Command> commands = new ArrayList<>();

    public void add(Command command){
        commands.add(command);
    }

    public void run(){
        Iterator<Command> iterator = commands.iterator();
        while ( iterator.hasNext() ){
            iterator.next().execute();
        }
    }

    public static void main(String[] args) {
        Macro macro = new Macro();
        macro.add(new Hello());
        macro.add(new World());
        macro.add(new IAm());
        macro.run();
    }
}
