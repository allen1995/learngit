package com.allen.dayup.thinkinjava.cahp13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: 20190598
 * @Date: 2019/11/7 11:48
 * @Description: 编译正则时，设置多行模式和忽略大小写
 */
public class ReFlags {

    public static void main(String[] args) {

        Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

        String s = "java has regex.\nJava has regex. \nJAVA has regex.";

        Matcher m = p.matcher(s);

        while ( m.find() ){
            System.out.println(m.group());
        }
    }
}
