package com.allen.dayup.thinkinjava.cahp13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: 20190598
 * @Date: 2019/11/8 10:03
 * @Description:
 */
public class Demo {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\b[Ssct]\\w+");
        Matcher m = p.matcher("");

        m.reset(" String test");
        while ( m.find() ){
            System.out.println(m.group());
        }
    }
}
