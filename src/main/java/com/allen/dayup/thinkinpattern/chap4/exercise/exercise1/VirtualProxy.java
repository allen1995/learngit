package com.allen.dayup.thinkinpattern.chap4.exercise.exercise1;

/**
 * @Auther: 20190598
 * @Date: 2020/4/16 17:23
 * @Description:
 */
public class VirtualProxy implements VirtualProxyBase {

    private Implementation implementation;

    public VirtualProxy() {
    }

    @Override
    public void g() {
        isInitedImpletation();
        implementation.g();
    }

    private void isInitedImpletation() {
        if( implementation == null ){
            implementation = new Implementation();
        }
    }

    public static void main(String[] args) {
        VirtualProxy proxy = new VirtualProxy();
        proxy.g();
    }
}
