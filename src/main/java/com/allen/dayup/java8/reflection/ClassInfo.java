package com.allen.dayup.java8.reflection;

import java.security.cert.CertificateExpiredException;

/**
 * @Auther: allen
 * @Date: 2020-04-04 12:00
 * @Description:
 */
public class ClassInfo {

    public static void main(String[] args) {
        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);
    }

    private static void printClassInfo(Class cls){
        System.out.println("class name:" + cls.getName());
        System.out.println("class simplename:" + cls.getSimpleName());
        if( cls.getPackage() != null ){
            System.out.println("Package name:" + cls.getPackage().getName());
        }

        System.out.println("is interface:" + cls.isInterface());
        System.out.println("is enum:" + cls.isEnum());
        System.out.println("is array:" + cls.isArray());
        System.out.println("is primitive:" + cls.isPrimitive() );
        System.out.println("-----------------------------");
    }
}
