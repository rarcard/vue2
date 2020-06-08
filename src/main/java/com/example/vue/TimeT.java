package com.example.vue;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author zyx
 * @Description:日期时间
 * @Create: 2020/5/25 11:33
*/
public class TimeT {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);
        LocalDateTime now =LocalDateTime.now();
        System.out.println(now);
    }
}
