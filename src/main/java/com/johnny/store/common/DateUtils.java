package com.johnny.store.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    final static String DEFAULT_PATTERN = "MM-dd-yyyy HH:mm:ss";

    public static String getCurrentDateTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static Date convert(String value) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(value);
    }

    public static String getRecentMonthDateTime(int recentMonth){
        GregorianCalendar gc=new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        gc.add(2,-recentMonth);

        return simpleDateFormat.format(gc.getTime());
    }
    /**
     * 获取date的月份的时间范围
     * @param date
     * @return
     */
    public static DateRange getMonthRange(Date date) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(date);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        setMaxTime(startCalendar);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(date);
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        setMaxTime(endCalendar);

        return new DateRange(startCalendar.getTime(), endCalendar.getTime());
    }
    /**
     * 获取当前季度的时间范围
     * @return current quarter
     */
    public static DateRange getThisQuarter() {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(Calendar.MONTH, ((int) startCalendar.get(Calendar.MONTH) / 3) * 3);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        setMinTime(startCalendar);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(Calendar.MONTH, ((int) startCalendar.get(Calendar.MONTH) / 3) * 3 + 2);
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        setMaxTime(endCalendar);

        return new DateRange(startCalendar.getTime(), endCalendar.getTime());
    }

    /**
     * 获取昨天的时间范围
     * @return
     */
    public static DateRange getYesterdayRange() {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.add(Calendar.DAY_OF_MONTH, -1);
        setMinTime(startCalendar);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.add(Calendar.DAY_OF_MONTH, -1);
        setMaxTime(endCalendar);

        return new DateRange(startCalendar.getTime(), endCalendar.getTime());
    }

    /**
     * 获取当前月份的时间范围
     * @return
     */
    public static DateRange getThisMonth(){
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        setMinTime(startCalendar);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        setMaxTime(endCalendar);

        return new DateRange(startCalendar.getTime(), endCalendar.getTime());
    }

    /**
     * 获取上个月的时间范围
     * @return
     */
    public static DateRange getLastMonth(){
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.add(Calendar.MONTH, -1);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        setMinTime(startCalendar);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.add(Calendar.MONTH, -1);
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        setMaxTime(endCalendar);

        return new DateRange(startCalendar.getTime(), endCalendar.getTime());
    }

    /**
     * 获取上个季度的时间范围
     * @return
     */
    public static DateRange getLastQuarter() {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(Calendar.MONTH, ((int) startCalendar.get(Calendar.MONTH) / 3 - 1) * 3);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        setMinTime(startCalendar);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(Calendar.MONTH, ((int) endCalendar.get(Calendar.MONTH) / 3 - 1) * 3 + 2);
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        setMaxTime(endCalendar);

        return new DateRange(startCalendar.getTime(), endCalendar.getTime());
    }

    private static void setMinTime(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    private static void setMaxTime(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
    }

    public static String format(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
        return sdf.format(date);
    }

    /**
     * 对比date1与date2两个时间之间的小时差
     * @param date1 待对比的时间
     * @param date2 对比时间
     * @return 返回两个时间的小时差值
     */
    public static long differenceHour(Date date1, Date date2){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return (date1.getTime() - date2.getTime()) / (3600 * 1000);
    }

    /**
     * 对比date1与date2两个时间之间的分钟差
     * @param date1 待对比的时间
     * @param date2 对比时间
     * @return 返回两个时间的小时差值
     */
    public static long differenceMinutes(Date date1, Date date2){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return (date1.getTime() - date2.getTime()) / (60 * 1000);
    }

    /**
     * 对比date1与date2两个时间之间的分钟差
     * @param fromDate 开始时间
     * @param toDate 戒指时间
     * @return 返回两个时间的分钟差值
     */
    public static DataDifference difference(String fromDate, String toDate) throws ParseException {
        DataDifference dataDifference = new DataDifference();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date data1 = format.parse(fromDate);
        Date date2 = format.parse(toDate);
        long between = date2.getTime() - data1.getTime();

        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long seconds = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

        dataDifference.setDay(day);
        dataDifference.setHour(hour);
        dataDifference.setMin(min);
        dataDifference.setSeconds(seconds);

        return dataDifference;
    }

    /**
     * 将累计的天、小时、分钟、秒转为标准的时间
     * @param totalDay 天
     * @param totalHour 小时
     * @param totalMinutes 分钟
     * @param totalSeconds 分钟
     * @return 标准时间
     */
    public static DataDifference convertToStandard(long totalDay, long totalHour, long totalMinutes, long totalSeconds){
        DataDifference standardTime = new DataDifference();
        long tempDays;
        long tempHours;
        long tempMinutes;

        long standardSeconds;
        long standardMinutes;
        long standardHours;


        //根据总秒数计算总分钟和标准秒数
        tempMinutes = totalMinutes + (long)Math.floor(totalSeconds / 60);
        standardSeconds = totalSeconds % 60;

        //根据总分钟计算总小时标准分钟
        tempHours = totalHour + (long)Math.floor(tempMinutes / 60);
        standardMinutes = tempMinutes % 60;

        //根据总小时计算总天数和标准小时
        tempDays = totalDay + (long)Math.floor(tempHours / 24);
        standardHours = tempHours % 24;

        standardTime.setDay(tempDays);
        standardTime.setHour(standardHours);
        standardTime.setMin(standardMinutes);
        standardTime.setSeconds(standardSeconds);

        return standardTime;
    }
}
