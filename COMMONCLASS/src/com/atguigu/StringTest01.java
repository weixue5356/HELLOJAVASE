package com.atguigu;

public class StringTest01 {



    public static void main(String[] args) {
        String rmk = "通行证号码: woshissfsdf12345678";
        String s = rmk.replaceAll("\\D", "");
        System.out.println(s);


    }

}
