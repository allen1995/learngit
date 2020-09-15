package com.allen.dayup.java8.io.stream;

import java.io.StringReader;
import java.util.Scanner;

/**
 * @Auther: allen
 * @Date: 2020-09-14 23:06
 * @Description:
 */
public class ScannerDemo {

    public static void main(String[] args) {
        StringReader reader = new StringReader("A,B,C");

        Scanner scanner = new Scanner(reader);
        scanner.useDelimiter(",");

        while ( scanner.hasNext() ){
            System.out.println(scanner.next());
        }

    }
}
