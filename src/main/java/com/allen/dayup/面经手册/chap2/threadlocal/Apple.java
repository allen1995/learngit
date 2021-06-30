package com.allen.dayup.面经手册.chap2.threadlocal;

/**
 * @Auther: allen
 * @Date: 2021-06-30 22:55
 * @Description:
 */
public class Apple {
    private String name;

    public Apple(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Apple[%s]被回收了！", name);
    }
}
