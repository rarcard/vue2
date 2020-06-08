package com.example.vue;

public class StringDemo {
    public static void main(String[] args) {
        int i=0;
/*

        */
/* StringBuffer 线程安全的可变字符序列 同步串行 速度较快*//*

       StringBuffer sb2=new StringBuffer();
        long t1=System.currentTimeMillis();
        for(i=0;i<100000;i++){
            sb2.append(i);
        }
        long t2=System.currentTimeMillis();
        System.out.println("StringBuffer:"+(t2-t1));

        */
/* StringBuilder 线程不安全 不保证同步 速度最快*//*

        StringBuilder sb=new StringBuilder();
         long t3=System.currentTimeMillis();
        for(i=0;i<100000;i++){
            sb.append(i);
        }
         long t4=System.currentTimeMillis();
        System.out.println("StringBuilder:"+(t4-t3));


        */
/* String 线程安全，速度最慢 *//*

        String sb3=new String();
        long t5=System.currentTimeMillis();
        for(i=0;i<100000;i++){
            sb3+=i;
        }
        long t6=System.currentTimeMillis();
        System.out.println("String:"+(t6-t5));


        String s;
        int j=1;
        s = j + "";
        s = String.valueOf(j);
*/





        //int => String
        int num = 123456789;
        //(1)num + ""
        long start = System.currentTimeMillis();//得到开始运行时系统时间
        for(i=0; i<100000; i++){
            String str = num + "";
        }
        long end = System.currentTimeMillis();//得到结束运行时系统时间
        System.out.println("num + \"\" : " + (end - start));

        //(2)String.valueOf(num)
        long start2 = System.currentTimeMillis();
        for(i=0; i<100000; i++){
            String str = String.valueOf(num);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("String.valueOf(num) : " + (end2 - start2));

        //(3)Integer.toString(num)
        long start3 = System.currentTimeMillis();
        for(i=0; i<100000; i++){
            String str = Integer.toString(num);
        }
        long end3 = System.currentTimeMillis();
        System.out.println("Integer.toString(num) : " + (end3 - start3));
    }
}
