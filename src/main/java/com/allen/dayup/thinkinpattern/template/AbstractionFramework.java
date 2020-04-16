package com.allen.dayup.thinkinpattern.template;

/**
 * @Auther: 20190598
 * @Date: 2020/4/16 13:32
 * @Description:
 */
public abstract class AbstractionFramework {
    public AbstractionFramework(){
        templateMethod();
    }

    abstract void customize1();

    abstract void customize2();

    private void templateMethod() {
        for (int i = 0; i < 5; i++) {
            customize1();
            customize2();
        }

    }

}
