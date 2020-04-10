package com.allen.dayup.程序员的算法趣题.chap1;

/**
 * 如果把某个数字按相反的顺序排列，得到的数字和原来相同，那个这个数字就是回文数。比如12321,这就是一个回文数。
 *
 * 问题：求大于10，且用十进制、二进制、八进制表示都是回文数的最小整数。
 *
 * 思路：如果用二进制表示，最高位一定为1，那最低位也就相应一定为1，所以这个数一定是基数。
 *
 * @Auther: 20190598
 * @Date: 2020/4/2 14:53
 * @Description:
 */
public class chap1 {

    public static void main(String[] args) {
        minPalindromicNumber();
    }

    public static int minPalindromicNumber(){
        Integer result = 11;

        while (true){
            if( result.toString().equals(reverse(result.toString())) &&
                Integer.toBinaryString(result).equals( reverse(Integer.toBinaryString(result))) &&
                Integer.toOctalString(result).equals( reverse( Integer.toOctalString(result))) ) {
                System.out.println(result);
                break;
            }
            result += 2;
        }

        return result;
    }

    private static String reverse(String str){
        final StringBuilder builder = new StringBuilder();
        for (int i = str.length()-1; i >= 0 ; i--) {
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
}
