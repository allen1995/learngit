package com.allen.dayup.java8.string;

import java.util.StringJoiner;
import java.util.stream.Stream;

/**
 * @Auther: 20190598
 * @Date: 2020/4/3 14:34
 * @Description:
 */
public class string {

    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(s);
        s = s.toUpperCase();
        System.out.println(s);

        String s1 = "hello";
        String s2 = "hello";
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s2):" + s1.equals(s2));

        String s3 = "hello";
        String s4 = "HELLO".toLowerCase();
        System.out.println("s3 == s4:" + (s3 == s4));
        System.out.println("s3.equals(s4):" + s3.equals(s4));

        //StringBuilder拼接字符产
        String[] names = {"Bob", "Alice", "Grace"};
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ");
        for (String name : names) {
            sb.append(name).append(", ");
        }
        // 注意去掉最后的", ":
        sb.delete(sb.length() - 2, sb.length());
        sb.append("!");
        System.out.println(sb.toString());

        //StringJoiner demo
        System.out.println(stringJoinerDemo());

        //String join()
        //String[] names = {"Bob", "Alice", "Grace"};
        String ss = String.join(", ", names);
        System.out.println(ss);

        System.out.println(Integer.toBinaryString( Integer.valueOf("-128")));

    }

    private static String stringJoinerDemo(){
        String[] names = {"Bob", "Alice", "Grace"};
        final StringJoiner sj = new StringJoiner(",");
        Stream.of(names).forEach( name -> sj.add(name));

        return  sj.toString();
    }
}
