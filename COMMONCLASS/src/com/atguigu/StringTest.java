package com.atguigu;


import jdk.nashorn.internal.ir.ReturnNode;

import java.util.concurrent.ForkJoinPool;

/**
 * 实现字符串的反转
 */
public class StringTest {

    public static void main(String[] args) {

       // System.out.println( reversal("helloworld"));
       // System.out.println(reversal2("helloworld"));
        System.out.println(reversal4("helloworld"));
    }


    public static String reversal (String str) {

        char[] chars = str.toCharArray();
       // str.getBytes() 转化为字节数组

        for (int i = 0,j = chars.length - 1; i < j ; i++,j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        //字符数组转化为字符串可以通过构造器
        return new String (chars);


    }

    public static String reversal2 (String str) {

        StringBuilder stringBuilder = new StringBuilder(str);

            return stringBuilder.reverse().toString();
    }

    public static String reversal3 (String str) {

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
             char temp = chars[i];
             chars[i] = chars[chars.length - 1 -i];
            chars[chars.length - 1 -i] = temp;

        }
        return new String(chars);



    }
    public static String reversal4 (String str) {

        StringBuffer buffer = new StringBuffer();
        for (int i = str.length() - 1; i >=0 ; i--) {
            buffer.append(str.charAt(i));

        }
             return buffer.toString();

    }

}
