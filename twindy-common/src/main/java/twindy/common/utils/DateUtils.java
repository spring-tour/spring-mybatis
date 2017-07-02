package twindy.common.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 常用时间处理方法
 * @author senola
 * 2015-07-01
 */
public class DateUtils {

    private static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"; //日期-时间类型格式
    private static String DATE_FORMAT = "yyyy-MM-dd"; // 日期类型格式
    private static String TIME_FORMAT = "HH:mm:ss"; // 时间类型格式

    private static ThreadLocal<SimpleDateFormat> threadDateTime = new ThreadLocal<SimpleDateFormat>();

    /**
     * 获取SimpleDateFormat实例
     * @return
     */
    private static SimpleDateFormat getSimpleDateFormat() {
        SimpleDateFormat sdf = threadDateTime.get();
        if(null == sdf) {
            sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
            threadDateTime.set(sdf);
        }
        return sdf;
    }

    /**
     * 获取SimpleDateFormat实例
     * @return
     */
    private static SimpleDateFormat getSimpleDateFormat(String format) {
        SimpleDateFormat sdf = threadDateTime.get();
        if(null == sdf) {
            sdf = new SimpleDateFormat(format);
            threadDateTime.set(sdf);
        }
        return sdf;
    }

    /**
     * 获取当前日期时间
     * @return
     */
    public static String getCurrentTime() {
        return getSimpleDateFormat().format(new Date());
    }

    /**
     * 格式化输出Date
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        return getSimpleDateFormat().format(date);
    }

    public static String formatDate(Date date, String format) {
        return getSimpleDateFormat(format).format(date);
    }

    /**
     * 将指定的字符串解析为时间类型
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date formateDate(String dateStr) throws ParseException {
        return getSimpleDateFormat().parse(dateStr);
    }

    /**
     * 在当前的时间基础上加上或者减去year年
     * @param year
     * @return
     */
    public static Date getYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, year);
        return cal.getTime();
    }

    /**
     * 在指定的时间基础上加上或者减去year年
     * @param date
     * @param year
     * @return
     */
    public static Date getYear(Date date, int year) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, year);
        return cal.getTime();
    }

    /**
     * 在指定的时间基础上加上或者减去month月
     * @param date
     * @param month
     * @return
     */
    public static Date getMonth(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }

    /**
     * 在指定的时间基础上加上或者减去day天
     * @param date
     * @param day
     * @return
     */
    public static Date getDay(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, day);
        return cal.getTime();
    }

    /**
     * 在指定的时间基础上加上或者减去hour小时
     * @param date
     * @param hour
     * @return
     */
    public static Date getHour(Date date, float hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, (int) (hour * 60));
        return cal.getTime();
    }

    /**
     * 在指定的时间基础上加上或者减去minute分钟
     * @param minute
     * @return
     */
    public static Date Minute(int minute) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, minute);
        return cal.getTime();
    }

    /**
     * 判断一个字符串是否为日期字符串
     * @param date
     * @return
     */
    public static boolean isDate(String date) {
        try {
            getSimpleDateFormat(DATE_TIME_FORMAT).parse(date);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 计算两个时间段的时间差（单位秒）
     * @param datet1
     * @param date2
     * @return
     */
    public static long differSecond(Date datet1, Date date2) {
        return Math.abs((date2.getTime() - datet1.getTime())) / 1000;
    }

    /**
     * 获取俩个时间之前的相隔的天数
     * @param startTime
     * @param endTime
     * @return
     */
    public static int differDay(Date startTime, Date endTime) {
        int days = 0;
        Calendar ca1 = Calendar.getInstance();
        Calendar ca2 = Calendar.getInstance();
        ca1.setTime(startTime);
        ca2.setTime(endTime);

        int year1 = ca1.get(Calendar.YEAR);
        int year2 = ca2.get(Calendar.YEAR);

        Calendar ca = null;
        if(ca1.before(ca2)) {
            days -= ca1.get(Calendar.DAY_OF_YEAR);
            days += ca2.get(Calendar.DAY_OF_YEAR);
            ca = ca1;
        } else {
            days -= ca2.get(Calendar.DAY_OF_YEAR);
            days += ca1.get(Calendar.DAY_OF_YEAR);
            ca = ca2;
        }
        for(int i = 0; i < Math.abs(year2 - year1); i++) {
            days += ca.getActualMaximum(Calendar.DAY_OF_YEAR);
            ca.add(Calendar.YEAR, 1);
        }
        return days;
    }
    /**
     * 时间date1和date2的时间差-(单位月)
     * @param date1
     * @param date2
     * @return
     */
    public static int differMonth(Date date1, Date date2) {
        int month = 0;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);

        int year1 = c1.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH);

        if(year1 == year2) {
            month = month2 - month1;
        } else {
            month = 12 * (year2 - year1) + (month2 - month1);
        }
        return Math.abs(month);
    }

    /**
     * 获取俩个时间的差(如相差 0天2时1分27秒)
     * @param date1
     * @param date2
     * @return
     */
    public static String differTime(Date date1, Date date2) {
        String differTime = "";
        try{
            long differMinute = Math.abs((date1.getTime() - date2.getTime()) / 1000);
            int day = (int) differMinute / (60 * 60 * 24);
            int hour = (int) (differMinute - day * 60 * 60 * 24) / (60 * 60);
            int minute = (int) (differMinute - day * 60 * 60 * 24 - hour * 60 * 60) / 60;
            int second = (int) (differMinute - day * 60 * 60 * 24 - hour * 60 * 60 - minute * 60);
            differTime =  day + "天" + hour + "时" + minute + "分" + second + "秒";
        }catch(Exception e) {
            e.printStackTrace();
        }
        return differTime;
    }
    /**
     * 测试类
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        Date d1 = new Date();
        Date d2 = getSimpleDateFormat(DATE_TIME_FORMAT).parse("2014-06-05 21:23:21");
        System.out.println(DateUtils.differDay(d1, d2));
    }
}