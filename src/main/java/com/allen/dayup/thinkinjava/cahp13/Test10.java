package com.allen.dayup.thinkinjava.cahp13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: 20190598
 * @Date: 2019/11/7 10:17
 * @Description: 对字符串Java now has regular expression 做正则匹配。
 *  ^Java \Breg.* n.w\s+h(a|i)s s? s* s+ s{4} s{1} s{0,3}
 */
public class Test10 {

    public static void main(String[] args) {
        String s = "Java now has regular expression";

        String regex1 = "^Java";
        String regex2 = "\\Breg.*";
        String regex3 = "n.w\\s+h(a|i)s";
        String regex4 = "s{4}";
        String regex5 = "s?";
        String regex6 = "s+";
        String regex7 = "s{1}";
        String regex8 = "s{0,3}";


        Pattern p = Pattern.compile(regex8);
        Matcher matcher = p.matcher(regex1);
        System.out.println(matcher.groupCount());


    }
}
