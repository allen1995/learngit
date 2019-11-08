package com.allen.dayup.thinkinjava.cahp13;

import javax.swing.plaf.metal.MetalFileChooserUI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: 20190598
 * @Date: 2019/11/7 10:44
 * @Description:
 */
public class Groups {

    public static final String POEM = "Twas brilling, and the slithy toves\n" +
            "Did  gyre and gimble in the wabe.\n" +
            "All mimsy were the borogoves,\n" +
            "And the mome raths outgrabe.\n\n" +
            "Beware the Jabberwock , my son, \n" +
            "The jaws that bite, the claws that catch.\n" +
            "Beware the jubjub bird, and shun\n" +
            "The frumious Bandersnath.";

    public static void main(String[] args) {
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);

        while ( m.find() ){
            for (int j = 0; j <= m.groupCount(); j++) {
                System.out.print("[" + m.group(j) + "]");
            }
            System.out.println();
        }
    }
}
