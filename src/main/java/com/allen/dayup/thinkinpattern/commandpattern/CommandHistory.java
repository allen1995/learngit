package com.allen.dayup.thinkinpattern.commandpattern;

import java.util.Stack;

/**
 * @Auther: 20190598
 * @Date: 2020/7/17 13:28
 * @Description:
 */
public class CommandHistory {

    private Stack<Command> history = new Stack<>();

    public void push(Command c){
        history.push(c);
    }

    public Command pop(){
        return history.pop();
    }

    public boolean isEmpty(){
        return history.isEmpty();
    }
}
