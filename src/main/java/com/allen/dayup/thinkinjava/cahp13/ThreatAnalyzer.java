package com.allen.dayup.thinkinjava.cahp13;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * @Auther: 20190598
 * @Date: 2019/11/8 11:18
 * @Description: 扫描分析告警日志
 */
public class ThreatAnalyzer {

    static String threatData = "172.16.15.210@01/11/2019\n" +
            "172.16.15.210@01/11/2019\n" +
            "172.16.15.212@02/11/2019\n" +
            "172.16.15.213@02/11/2019\n" +
            "next log section with different format data.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(threatData);

        String regex = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" + "(\\d+/\\d+/\\d+)";

        while ( scanner.hasNext(regex)){
            scanner.next(regex);
            MatchResult match = scanner.match();

            String ip = match.group(1);
            String date = match.group(2);

            System.out.format("Threat on %s from %s \n", date, ip);
        }
    }
}
