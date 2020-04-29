package com.allen.dayup.java8.annotion;

import java.lang.reflect.Field;

/**
 * @Auther: allen
 * @Date: 2020-04-04 23:05
 * @Description:
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Person person2 = new Person("allen","xxxxxx顶顶顶顶顶顶顶顶顶顶顶顶顶xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        check(person2);
    }

    private static void check(Person person) throws IllegalAccessException {
        Field[] fields = person.getClass().getDeclaredFields();

        for( Field field : fields ){
            Range range = field.getAnnotation(Range.class);
            field.setAccessible(true);
            if( range != null ){
                Object value = field.get(person);
                if( value instanceof String ){
                    String s = (String) value;
                    if( s.length() < range.min() || s.length() > range.max()){
                        throw new IllegalArgumentException("字段长度不对");
                    }else {
                        System.out.println("person字段都符合长度要求！");
                    }
                }
            }
        }
    }
}
