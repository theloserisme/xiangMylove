package com.pikachu.utils.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeUtils {

    public static String getDateStr(String type) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(type);
        Date date = new Date();
        return sdf.format(date);
    }

    public static String timeUpdate(long time) {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMdd");// HH:mm:ss
//获取当前时间
        Date date = new Date(time);
        return simpleDateFormat1.format(date);
    }
    /**
     * 获取当天0点时间
     */
    public static Date getTimesMorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
        //return (cal.getTimeInMillis());
    }


    /**
     * 获得当天24点时间
     */
    public static Date getTimesNight() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
        //return  (cal.getTimeInMillis() / 1000);
    }


    /**
     * 获得本周一0点时间
     */
    public static Date getTimesWeekMorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONDAY),
                cal.get(Calendar.DAY_OF_MONTH),
                0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
        //return (cal.getTimeInMillis() / 1000);
    }

    /**
     * 获得本周日24点时间
     */
    public static Date getTimesWeekNight() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONDAY),
                cal.get(Calendar.DAY_OF_MONTH),
                0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
        //return (cal.getTimeInMillis() / 1000);
    }


    /**
     * 获取本月第一天0点时间
     */
    public static Date getTimesMonthMorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY),
                cal.get(Calendar.DAY_OF_MONTH),
                0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
        //return /*(int)*/ (cal.getTimeInMillis());
    }


    /**
     * 获得本月最后一天24点时间
     */
    public static Date getTimesMonthNight() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONDAY),
                cal.get(Calendar.DAY_OF_MONTH),
                0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        return cal.getTime();
        //return (cal.getTimeInMillis() / 1000);
    }


    /**
     * 获取某一天的开始时间
     */
    public static Date getStartOfDay(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
        //return (cal.getTimeInMillis() / 1000);
    }

    /**
     * 获取某一天的结束时间
     */
    public static Date getEndOfDay(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
        //return (cal.getTimeInMillis() / 1000);
    }


    /**
     * 获取某月的第一天0点时间
     */
    public static Date getDayOfMonthStart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int firstDay = cal.getMinimum(Calendar.DATE);
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
        //return  (cal.getTimeInMillis() / 1000);
    }


    /**
     * 获取某月的最后一天24点时间
     */
    public static Date getDayOfMonthEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }


    public static List<Date> getDateMonthList(long start, long end) {
        return getDateMonthList(longToDate(start), longToDate(end));
    }


    //获取某段时间内的所有天
    public static List<Date> getDateMonthList(Date start, Date end) {
        List<Date> dateList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        dateList.add(calendar.getTime());

        //倒序时间,正序after改before
        while (calendar.getTime().before(end)) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            dateList.add(calendar.getTime());
        }
        return dateList;
    }


    //获取某段时间内的一年月数
    public static List<Date> getMonthList(Date time) {
        List<Date> dateList = new ArrayList<>();


        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.DAY_OF_YEAR, 1);
        cal1.setTime(time);
        cal1.set(Calendar.DAY_OF_YEAR, cal1.getActualMinimum(Calendar.DAY_OF_YEAR));
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        //cal1.set(Calendar.DAY_OF_MONTH, 0);


        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_YEAR, 1);
        cal.setTime(time);
        cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        //cal.set(Calendar.DAY_OF_MONTH, 0);


        Calendar curr = cal1;
        while (curr.before(cal)) {
            dateList.add(curr.getTime());
            curr.add(Calendar.MONTH, 1);
        }

        return dateList;
    }


    // 获取某时间的   前后某个月  的某天的0点时间
    public static Date getUpMonthTime(Date startTime, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        calendar.add(Calendar.MONTH, month);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }


    /**
     * 获取当前时间为本月的第几天, 几周, 本周的第几天
     *
     * @param type ==1 本月第几天   ==2 本月第几周   ==3 本周第几天
     * @return int
     */
    public static int getMonthNsDay(int type) {
        Calendar calendar = Calendar.getInstance();
        int day = 0;
        int monthDay = calendar.get(Calendar.DAY_OF_MONTH);
        int monthWeek = calendar.get(Calendar.WEEK_OF_MONTH);
        int monthWeekDay = calendar.get(Calendar.DAY_OF_WEEK);
        if (monthWeekDay == 1) {
            monthWeekDay = 7;
            monthWeek = monthWeek - 1;
        } else {
            monthWeekDay = monthWeekDay - 1;
        }
        switch (type) {
            case 1:
                return monthDay;
            case 2:
                return monthWeek;
            case 3:
                return monthWeekDay;
        }
        return day;
    }


    /**
     * 获得两个日期间距多少天
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int getTimeDistance(Date beginDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(beginDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        long dayDistance = (toCalendar.getTimeInMillis() - fromCalendar.getTimeInMillis()) / (1000 * 3600 * 24);
        dayDistance = Math.abs(dayDistance);
        return (int) dayDistance;
    }


    public static class TimeFormat {
        public String y;
        public String m;
        public String d;
        public int week;
        public String hh;
        public String mm;
        public String ss;

        public TimeFormat(String y, String m, String d, int week, String hh, String mm, String ss) {
            this.y = y;
            this.m = m;
            this.d = d;
            this.week = week;
            this.hh = hh;
            this.mm = mm;
            this.ss = ss;
        }
    }


    public static TimeFormat dateToTimeFormat(long time) {
        return dateToTimeFormat(new Date(time));
    }


    public static TimeFormat dateToTimeFormat(Date time) {
        Calendar cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH);
        int d = cal.get(Calendar.DAY_OF_MONTH);
        int w = cal.get(Calendar.DAY_OF_WEEK);
        int hh = cal.get(Calendar.HOUR_OF_DAY);
        int mm = cal.get(Calendar.MINUTE);
        int ss = cal.get(Calendar.SECOND);

        return new TimeFormat(
                y + "",
                m < 10 ? "0" + (m + 1) : (m + 1) + "",
                d < 10 ? "0" + d : d + "",
                w,
                hh < 10 ? "0" + hh : hh + "",
                mm < 10 ? "0" + mm : mm + "",
                ss < 10 ? "0" + ss : ss + "");
    }

    public static String judgementWeek(int we) {
        if (we == 1) {
            return "星期天";
        } else if (we == 2) {
            return "星期一";
        } else if (we == 3) {
            return "星期二";
        } else if (we == 4) {
            return "星期三";
        } else if (we == 5) {
            return "星期四";
        } else if (we == 6) {
            return "星期五";
        } else if (we == 7) {
            return "星期六";
        }
        return null;

    }
    public static String judgementWeekOne(int we) {
        if (we == 1) {
            return "周日";
        } else if (we == 2) {
            return "周一";
        } else if (we == 3) {
            return "周二";
        } else if (we == 4) {
            return "周三";
        } else if (we == 5) {
            return "周四";
        } else if (we == 6) {
            return "周五";
        } else if (we == 7) {
            return "周六";
        }
        return null;

    }

    public static long dateToLong(Date date) {
        return date.getTime();
    }


    public static Date longToDate(long time) {
        return new Date(time);
    }


    public static String dataToStr(Date date, String type) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(type);
        return sdf.format(date);
    }


    // 定时器
    public static void timing(long time, Runnable runnable) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            UiUtils.runUi(runnable);
        });
        thread.start();
    }


    // 定时循环
    public static Thread timingLoop(long time, Runnable runnable) {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    UiUtils.runUi(runnable);
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        return thread;
    }

}
