package com.allen.dayup.thinkinjava.cahp13;

import java.lang.invoke.WrongMethodTypeException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: 20190598
 * @Date: 2019/11/7 11:16
 * @Description: 找出文本中所有不以大写字母开头的词
 */
public class Test15 {

    public static final String POEM = "Twas brilling, and the slithy toves\n" +
            "Did  gyre and gimble in the wabe.\n" +
            "All mimsy were the borogoves,\n" +
            "And the mome raths outgrabe.\n\n" +
            "Beware the Jabberwock , my son, \n" +
            "The jaws that bite, the claws that catch.\n" +
            "Beware the jubjub bird, and shun\n" +
            "The frumious Bandersnath.";

    /**
     * 先分割文本，然后每个单词做正则匹配
     * @param args
     */
    public static void main(String[] args) {
        //保存统计结果
        Set<String> wordSet = new HashSet<>();
        //编译匹配首字母大写的正则
        Pattern p = Pattern.compile("^[^A-Z]");
        String[] words = POEM.split(" ");
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

        System.out.println(words);

        for ( String word : words ){
            Matcher m = p.matcher(word.trim());
            System.out.println(m.lookingAt());
            if(m.lookingAt()){
                wordSet.add(word);
            }
        }

        System.out.println(wordSet);
    }
}
