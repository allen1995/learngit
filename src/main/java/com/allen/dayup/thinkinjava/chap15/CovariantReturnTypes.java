package com.allen.dayup.thinkinjava.chap15;

/**
 * @Auther: 20190598
 * @Date: 2019/11/18 15:26
 * @Description:
 */
public class CovariantReturnTypes {

    void test(DerivedGetter d){
        Derived d2 = d.get();
        System.out.println(d2.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        CovariantReturnTypes crt = new CovariantReturnTypes();
        crt.test(new DerivedGetter() {
            @Override
            public Derived get() {
                return new Derived();
            }
        });
    }
}

class Base{}

class Derived extends Base{}

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter{
    Derived get();
}




