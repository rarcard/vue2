package com.example.vue;

import org.springframework.stereotype.Service;

import java.util.Scanner;
@Service
public class Triangle2 {

    /**
     * @Author zyx
     * @Description:判断三角形形状
     * @Create: 2020/5/16 20:17
    */
    public  int isTriangles(double a, double b, double c){
        if(a+b>c&&a+c>b&&b+c>a){
            System.out.println("三角形周长:"+(a+b+c));
            if(a==b&&a==c){
                System.out.println("等边三角形");
                return 2;
            }
            if(a==b||a==c||b==c){
                System.out.println("等腰三角形");
                return 3;
            }
            System.out.println("普通三角形");
            return 1;
        }
        System.out.println("错误,无法构成三角形");
        return 0;
    }
    /**
     * @Author zyx
     * @Description:计算三角形面积 已知三边
     * @Create: 2020/5/16 21:22
    */
    public double area(double a,double b,double c){
        return 0.25*Math.sqrt((a+b+c)*(a+b-c)*(a+c-b)*(b+c-a));
    }
}
