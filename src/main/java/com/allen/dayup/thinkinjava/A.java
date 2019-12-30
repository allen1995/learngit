package com.allen.dayup.thinkinjava;

/**
 * @Auther: 20190598
 * @Date: 2019/12/6 14:44
 * @Description:
 */
public class A {

    private String name;

    private long id;

    public A(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
