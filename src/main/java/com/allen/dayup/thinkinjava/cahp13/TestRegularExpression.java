package com.allen.dayup.thinkinjava.cahp13;

import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: 20190598
 * @Date: 2019/11/7 09:57
 * @Description:
 */
public class TestRegularExpression {

    public static void main(String[] args) {
        if( args.length < 2){
            System.out.println("Usage:\n java TestRegularExpression charactorSequence in to small.");
            System.exit(0);
        }

        System.out.println("Input:" + args[0]);
        for (String arg : args ){
            System.out.println("Test Expression:" + arg);

            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            while ( m.find() ){
                System.out.println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end()-1)  );
            }

        }
    }
}
