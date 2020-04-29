package com.allen.dayup.java8.stream;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @Auther: allen
 * @Date: 2020-04-18 18:43
 * @Description:
 */
public class SupplierDemo {

    public static void main(String[] args) {
        //getLongSupplier是把SupplierDemo的getLong方法抽象成一个变量
        Supplier<Long> getLongSupplier = SupplierDemo::getLong;
        //Supplier.get():调用get方法，并返回getLong方法的返回值
        System.out.println(getLongSupplier.get());
    }


    private static Long getLong(){
      return new Random().nextLong();
    }
}
