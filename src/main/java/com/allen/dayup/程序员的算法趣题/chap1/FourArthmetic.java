package com.allen.dayup.程序员的算法趣题.chap1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @Auther: 20190598
 * @Date: 2020/4/3 09:59
 * @Description:
 */
public class FourArthmetic {

    static Map<String, Integer> symbolPirorMap = new HashMap<>();

    static {
        symbolPirorMap.put("+",1);
        symbolPirorMap.put("-",1);
        symbolPirorMap.put("*",2);
        symbolPirorMap.put("/",2);
    }

    public static void main(String[] args) throws Exception {
        //Pattern p = Pattern.compile("[0-9]*");
        //        //Matcher matcher = p.matcher("1231");
        //        //System.out.println(matcher.group(0));
        //String[] arr = "12*3+3".split("[+-/*]");
        //System.out.println(arr.length);
        //Stream.of().forEach(System.out::println);
        //String[] arr = {"(","12"};
        //System.out.println(arr[0].equals("("));
        //9+（3-1）*3+10/2
        String[] arr = {"9","+","(","3","-","1","*","3","+","10","/","2"};
        System.out.println(toSuffixExpression(arr));


    }


    /**
     * 计算表达式的值
     * @param suffixExpression
     * @return
     */
    private static int compute(String suffixExpression){
        Stack<Integer> stack = new Stack<>();
        String symbol = "+-*/";

        for (int i = 0; i < suffixExpression.length(); i++) {
            if( symbol.indexOf(suffixExpression.charAt(i)) > 0  ){
                int result = 0;
                int a = stack.pop();
                int b = stack.pop();

                switch (suffixExpression.charAt(i)){
                    case '+':
                        result = a + b;
                        stack.push(result);
                        break;
                    case '-':
                        result = a - b;
                        stack.push(result);
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                }
            } else {
                stack.push( Integer.valueOf(suffixExpression.charAt(i)));
            }
        }


        return stack.pop();
    }


    /**
     * 中缀表达式转换成后缀表达式
     * 中缀表达式：
     * 9+（3-1）*3+10/2
     * 对应形式的后缀表达式：
     * 9 3 1 - 3 * + 10 2 / +
     *
     * 转换规则：从左至右依次读取，遇见数字就输出，遇见符号（如果是‘（’，直接入栈）就先判断与其栈顶符号的优先级，
     * 若是‘）’，或优先级小于栈顶符号，则栈顶元素依次出栈，直到遇见‘（’，或全部弹出，之后再将当前符号入栈（‘）’不需要入栈），
     * 一直到中缀表达式输入完毕，若符号栈中还存有符号，依次弹出。
     *
     * @param expressionArr
     * @return
     */
    private static String toSuffixExpression(String[] expressionArr) throws Exception {
        if( expressionArr.length == 0 ){
            throw new Exception("计算的表达式不能为空！");
        }

        //String[] expressionArr = expression.split("[+-/*]");

        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < expressionArr.length; i++) {
            if( expressionArr[i].equals("(")) {
                stack.push(expressionArr[i]);
            } else if ( expressionArr[i].equals(")")){
                while ( stack.peek() != "(" ){
                    result.append(stack.pop());
                }
            } else if( expressionArr[i].matches("\\d*") ){
                result.append(expressionArr[i]);
            } else if ( stack.size() == 0 || stack.peek() == "(" || isPirorTopStack(stack.peek(), expressionArr[i])){
                stack.push(expressionArr[i]);
            } else {
                while ( stack.size() !=  0 ){
                    result.append(stack.pop());
                }
            }
        }

        while ( stack.size() != 0 ){
            result.append(stack.pop());
        }


        return result.toString();
    }

    private static boolean isPirorTopStack(String peek, String s) {
        return symbolPirorMap.get(s)-symbolPirorMap.get(peek)>0;
    }

    private static boolean isNumber(String str) {


        //Pattern pattern =

        return false;
    }
}
