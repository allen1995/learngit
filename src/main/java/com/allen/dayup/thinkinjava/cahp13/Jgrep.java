package com.allen.dayup.thinkinjava.cahp13;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: 20190598
 * @Date: 2019/11/8 09:21
 * @Description:
 * 读取指定路径下的文件，匹配每行中以【Ssct】开头的单词，打印单词以及其位置
 * args[filePath, "\b[Ssct]\w+"]
 * \b:匹配单词分界
 * \w:匹配所有单词
 */
public class Jgrep {

    public static void main(String[] args) throws Exception{
        if( args.length < 2 ){
            System.out.println("Usage: java Jgrep file regex.");
            System.exit(0);
        }
        System.out.println(args[1]);

        Pattern p = Pattern.compile(args[1]);

        int index = 0;
        BufferedReader read = new BufferedReader(new FileReader(new File(args[0])));
        String line;

        Matcher m = p.matcher("");
        while ( (line = read.readLine()) != null ){
            m.reset(line);

            while ( m.find() ){
                System.out.println(index++ + "," + m.group() + " :" + m.start());
            }
        }

    }
}
