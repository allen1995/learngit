package com.allen.dayup.thinkinjava.chap16.section5;

import java.util.Arrays;

/**
 * @Auther: 20190598
 * @Date: 2019/12/4 15:35
 * @Description:
 */
public class ParameterizedArrayType {

    public static void main(String[] args) {
        Integer[] intArr = {1,2,3};
        Double[] douArr = {2.1,2.1,2.2};

        Integer[] intArr2 = new ClassParameter<Integer>().f(intArr);
        Double[] douArr2 = new ClassParameter<Double>().f(douArr);
        System.out.println("intArr2: " + Arrays.toString(intArr));
        System.out.println("douArr2: " + Arrays.toString(douArr));

        Integer[] intArr3 = MethodParameter.f(intArr);
        Double[] douArr3 = MethodParameter.f(douArr);
        System.out.println("intArr3: " + Arrays.toString(intArr3));
        System.out.println("douArr3: " + Arrays.toString(douArr3));
     }
}


class ClassParameter<T> {

    public T[] f(T[] arg){
        return arg;
    }
}

class MethodParameter{

    public static <T> T[] f(T[] arg){
        return arg;
    }
}
