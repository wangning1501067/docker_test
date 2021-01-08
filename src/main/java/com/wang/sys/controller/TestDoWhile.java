package com.wang.sys.controller;

import java.util.Scanner;
public class TestDoWhile{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String name="zhangsan";//定义原始用户和密码
        String password="123";
        String inputname="";//定义输入的
        String inputpass="";
        boolean cl=false;//利用布尔型转换，用于下面的循环中
        do{
            System.out.println("请输入用户名");
            inputname=input.next();
            System.out.println("请输入密码");
            inputpass=input.next();
            if(!name.equals(inputname) || !password.equals(inputpass)){
                cl=true;//和原始的用户名与密码不同，CL和定义的布尔型不一致
                System.out.println("用户名或密码错误，请重新输入");
            }
            else{
                cl=false;
                System.out.println("输入正确！欢迎登陆");
            }
        }while(cl);//当与定义一样时，循环结束
        System.out.println("======================");
    }
}//学习了do.....while结构
