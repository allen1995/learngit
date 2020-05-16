package com.allen.dayup.thinkinpattern.chap4.statemachine;

/**
 * @Auther: 20190598
 * @Date: 2020/4/16 14:42
 * @Description:
 */
public class Washer extends StateMachine {

    private int i = 0;

    private State[] states = {new Wash(),new Spin(),new Rinse(),new Wash(),new Rinse()};

    public Washer() {
        runAll();
    }

    public static void main(String[] args) {
        Washer washer = new Washer();
    }

    @Override
    protected boolean changeState() {

        if( i < states.length ){
            currentState = states[i++];
            return true;
        }
        return false;
    }


}
