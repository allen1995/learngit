package com.allen.dayup.thinkinpattern.statemachine;

/**
 * @Auther: 20190598
 * @Date: 2020/4/16 14:37
 * @Description:
 */
public abstract class StateMachine {

    protected State currentState;

    protected abstract boolean changeState();

    protected final void runAll(){
        while ( changeState()){
            currentState.run();
        }
    }
}
