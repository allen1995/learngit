package com.allen.dayup.arithmetic;

import com.google.common.base.Splitter;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/1/9 09:42
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<String>(10);
        list.add(2, "1");
        System.out.println(list.get(1));


    }

    public static LocalDateTime test(String opentimeHex) {
        if( opentimeHex != null && opentimeHex.length() > 0 && (new BigInteger(opentimeHex, 16).intValue() > 0)) {
            List<String> opentimeHexList = Splitter.fixedLength(2).splitToList(opentimeHex);
            String opentime = opentimeHexList.stream()
                    //16进制转换成十进制
                    .map( s -> {
                        String result = "";

                        BigInteger bigInteger = new BigInteger(s, 16);
                        int value = bigInteger.intValue();
                        if( value/10 == 0 ){
                            result = "0" + value;
                        } else {
                            result = String.valueOf(value);
                        }
                        return result;
                    })
                    .reduce("", (a,b) -> a+b);

            LocalDateTime opentimeDate = LocalDateTime.parse(opentime, DateTimeFormatter.ofPattern("yyMMddHHmmss"));
            return opentimeDate;
        }

        return null;
    }

    private static void count(int a){
        a++;
    }
}
