package com.atguigu;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class Address {

  //获取域名和地址
    public static void main(String[] args) throws Exception {

       InetAddress inetAddress = InetAddress.getByName("www.atguigu.com");

        System.out.println(inetAddress);
       // System.out.println(inetAddress.getAddress());
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress());

        System.out.println(InetAddress.getLocalHost().getHostAddress());

        System.out.println(InetAddress.getLocalHost().getHostName());



    }
}
