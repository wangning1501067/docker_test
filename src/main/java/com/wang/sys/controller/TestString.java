package com.wang.sys.controller;

import java.util.Scanner;

public class TestString {
    public static void main(String[] args) {
        String s = "";// 共65534个a
        for (int i = 0; i <=65539 ; i++) {
            s+= "a";
        }
        System.out.println(s.length());

        String s1 = "a...a";// 共65535个a
        System.out.println(s1.length());



//        StringBuilder sb = new StringBuilder();
//        sb.append("String");
//        sb.append("String");
//        String str = sb.toString();
//        String[] parts = str.split(",");
//        System.out.println(parts.length);
    }


}
