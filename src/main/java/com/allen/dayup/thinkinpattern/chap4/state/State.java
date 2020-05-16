package com.allen.dayup.thinkinpattern.chap4.state;

/**
 * @Auther: 20190598
 * @Date: 2020/4/16 13:55
 * @Description:
 */
public class State implements StateBase {

    private StateBase impletation;

    public State(StateBase impletation) {
        this.impletation = impletation;
    }

    private void changeState(StateBase impletation){
        this.impletation = impletation;
    }

    public static void main(String[] args) {
        State state = new State(new Impletation1());
        state.f();
        state.g();
        state.h();

        System.out.println("-------------------------");
        System.out.println("切换状态：impletation2");
        state.changeState(new Impletation2());
        state.g();
        state.h();
        state.f();
    }

    @Override
    public void g() {
        impletation.g();
    }

    @Override
    public void h() {
        impletation.h();
    }

    @Override
    public void f() {
        impletation.f();
    }
}
