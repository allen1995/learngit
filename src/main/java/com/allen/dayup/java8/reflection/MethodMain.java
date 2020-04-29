package com.allen.dayup.java8.reflection;

/**
 * @Auther: allen
 * @Date: 2020-04-04 14:07
 * @Description:
 */
public class MethodMain {

    public static void main(String[] args) throws NoSuchMethodException {
        Class stdClass = Student.class;
        System.out.println("getScore:" + stdClass.getMethod("getScore",String.class));
        System.out.println("getName:" + stdClass.getMethod("getName"));
        System.out.println("getGrade:" + stdClass.getDeclaredMethod("getGrade", int.class));
    }

    static class Student extends Person {
        public int getScore(String type){
            return 19;
        }

        private int getGrade(int year){
            return 1;
        }
    }

    static class Person {
        public String getName(){
            return "Person";
        }
    }
}
