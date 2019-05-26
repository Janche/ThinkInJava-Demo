package com.lirong.think.date;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * @author lirong
 * @desc 测试java日期类
 * @date 2019/05/26 12:05
 */

public class TestJavaDate {

    @Test
    public void testLocalDateTime() {

        LocalDate localDate = LocalDate.now();
        int dayOfYear = localDate.getDayOfYear();
        int dayOfMonth = localDate.getDayOfMonth();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        System.out.println(localDate.getYear()+"-"+localDate.getMonthValue()+"-"+localDate.getDayOfMonth());
        System.out.println(dayOfYear +", "+ dayOfMonth +", "+ dayOfWeek);

        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue());
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());
        System.out.println(dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(dt.plusDays(2).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(dt.plusDays(2).minusMonths(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(dt.plusDays(3).minusMonths(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(dt.minusMonths(3).plusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Test
    public void getLastDayOfMonth() {
        Calendar time = Calendar.getInstance();
        int actualMaximum = time.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(actualMaximum);
    }



}
