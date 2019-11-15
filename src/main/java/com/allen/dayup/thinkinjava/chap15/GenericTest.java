package com.allen.dayup.thinkinjava.chap15;

/**
 * @Auther: 20190598
 * @Date: 2019/11/13 14:25
 * @Description:
 */
public class GenericTest <T extends Light> {

    public void genericMethod(T t){
        t.useEletricity();
        t.light();
    }

    public static void main(String[] args) {
        GenericTest<WhiteLight> genericTest = new GenericTest<>();
        genericTest.genericMethod(new WhiteLight());
    }
}

class WhiteLight implements Light {

    @Override
    public void light() {
        System.out.println("GenericTest.light");
    }

    @Override
    public String useEletricity() {
        System.out.println("WhiteLight.useEletricity");
        return null;
    }

    public void atTop(){
        System.out.println("WhiteLight.atTop.");
    }

    /**
     * @Auther: 20190598
     * @Date: 2019/11/13 14:24
     * @Description:
     */

}

interface Light {

    void light();

    String useEletricity();
}
