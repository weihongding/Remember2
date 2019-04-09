package com.example.remember.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    // 时间String格式 2019-4-8 15:03:59

    //判断是否为合法的标准日期格式
    public static boolean isFormDate(String str) {
        boolean convertSuccess = true;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }

    //获取标准日期字符串中的年份
    public static String getYear(String str) {
        int index = str.indexOf("-");
        return str.substring(0, index);
    }

    //获取标准日期字符串中的月份
    public static String getMonth(String str) {
        int index1 = str.indexOf("-") + 1;
        int index2 = str.indexOf("-", index1);
        String resultstr = str.substring(index1, index2);
        if(resultstr.startsWith("0")){
            resultstr = resultstr.substring(1,2);
        }
        return resultstr;
    }

    //获取标准日期字符串中的日期
    public static String getDay(String str) {
        int index1 = str.lastIndexOf("-") + 1;
        int index2 = str.indexOf(" ");
        String resultstr = str.substring(index1, index2);
        if(resultstr.startsWith("0")){
            resultstr = resultstr.substring(1,2);
        }
        return resultstr;
    }

    //获取标准日期字符串中的时
    public static String getH(String str) {
        int index1 = str.indexOf(" ") + 1;
        int index2 = str.indexOf(":");
        return str.substring(index1, index2);
    }

    //获取标准日期字符串中的分
    public static String getM(String str) {
        int index1 = str.indexOf(":") + 1;
        int index2 = str.indexOf(":", index1);
        return str.substring(index1, index2);
    }

    //获取标准日期字符串中的秒
    public static String getS(String str) {
        int index1 = str.lastIndexOf(":") + 1;
        int index2 = str.length();
        return str.substring(index1, index2);
    }

    //根据传入的日期获取所在周的日期list
    public static List<Date> getWeek(Date mdate) {
        int b = mdate.getDay();
        Date fdate;
        List<Date> list = new ArrayList<Date>();
        Long fTime = mdate.getTime() - b * 24 * 3600000;
        for (int a = 1; a <= 7; a++) {
            fdate = new Date();
            fdate.setTime(fTime + (a * 24 * 3600000));
            list.add(a-1, fdate);
        }
        return list;
    }

    public static String dateToStr(Date mdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(mdate);
    }

    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    //获取当前年份
    public static int getYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    //获取当前月份
    public static int getMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    //获取当前日期是该月的第几天
    public static int getCurrentDayOfMonth() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    //获取当前日期是该周的第几天
    public static int getCurrentDayOfWeek() {
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
    }


    //获取当前是几点
    public static int getHour() {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);//二十四小时制
    }

    //获取当前是几分
    public static int getMinute() {
        return Calendar.getInstance().get(Calendar.MINUTE);
    }

    //获取当前秒
    public static int getSecond() {
        return Calendar.getInstance().get(Calendar.SECOND);
    }

    //根据传入的年份和月份，获取当前月份的日历分布
    public static int[][] getDayOfMonthFormat(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);//设置时间为每月的第一天
        //设置日历格式数组,6行7列
        int days[][] = new int[6][7];
        //设置该月的第一天是周几
        int daysOfFirstWeek = calendar.get(Calendar.DAY_OF_WEEK);
        //设置本月有多少天
        int daysOfMonth = getDaysOfMonth(year, month);
        //设置上个月有多少天
        int daysOfLastMonth = getLastDaysOfMonth(year, month);
        int dayNum = 1;
        int nextDayNum = 1;
        //将日期格式填充数组
        for (int i = 0; i < days.length; i++) {
            for (int j = 0; j < days[i].length; j++) {
                if (i == 0 && j < daysOfFirstWeek - 1) {
                    days[i][j] = daysOfLastMonth - daysOfFirstWeek + 2 + j;
                } else if (dayNum <= daysOfMonth) {
                    days[i][j] = dayNum++;
                } else {
                    days[i][j] = nextDayNum++;
                }
            }
        }
        return days;
    }

    //根据传入的年份和月份，判断上一个月有多少天
    public static int getLastDaysOfMonth(int year, int month) {
        int lastDaysOfMonth = 0;
        if (month == 1) {
            lastDaysOfMonth = getDaysOfMonth(year - 1, 12);
        } else {
            lastDaysOfMonth = getDaysOfMonth(year, month - 1);
        }
        return lastDaysOfMonth;
    }

    //根据传入的年份和月份，判断当前月有多少天
    public static int getDaysOfMonth(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (isLeap(year)) {
                    return 29;
                } else {
                    return 28;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
        return -1;
    }

    //判断是否为闰年
    public static boolean isLeap(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }
}