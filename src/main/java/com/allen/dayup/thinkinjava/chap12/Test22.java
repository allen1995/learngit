package com.allen.dayup.thinkinjava.chap12;

/**
 * @Auther: 20190598
 * @Date: 2019/11/5 17:20
 * @Description:
 */
public class Test22 {

    public static void main(String[] args) {
        Test22 test22 = new Test22();
        //Object s = "java";
        //test22.g(s);
        //System.out.println(s);
        //int val = 100;
        //test22.g(val);
        //System.out.println(val);

        Simple simple = new Simple();
        simple.setAge(10);
        simple.setName("bob");
        System.out.println(simple);
        test22.f(simple);
        System.out.println(simple);
    }

    public void g(Object s){

        s = "new String";
    }

    public void g(int val){

        val = 9999;
    }

    public void f(Simple simple){
        simple.setAge(100);
        simple.setName("allen");
    }
}

class Simple{
    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Simple{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}