package com.wang.sys.controller;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class TestTimeZone {

    /**
     * 获取时区
     * @return
     */
    public static String getTimeZone(){
        Calendar cal = Calendar.getInstance();
        int offset = cal.get(Calendar.ZONE_OFFSET);
        cal.add(Calendar.MILLISECOND, -offset);
        Long timeStampUTC = cal.getTimeInMillis();
        Long timeStamp = System.currentTimeMillis();
        Long timeZone = (timeStamp - timeStampUTC) / (1000 * 3600);
        System.out.println(timeZone.intValue());
        return String.valueOf(timeZone);

    }

    /**
     * 获取指定时区的当前时间字符串
     * @param timezone +8:00
     * @return
     */
    public static String getDateString(String timezone){
        //设置时区，如：+8:00 或者取时区id(GMT)
        TimeZone time = TimeZone.getTimeZone(timezone);
        //格式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 设置时区
        TimeZone.setDefault(time);
        // 获取实例
        Calendar calendar = Calendar.getInstance();
        //获取Date对象
        Date date = calendar.getTime();
        return format.format(date);
    }

    /**
     * 根据时区获取时间
     * @param timeZoneOffset
     * @return
     */
    public static String getFormatedDateString(float timeZoneOffset){
        if (timeZoneOffset > 13 || timeZoneOffset < -12) {
            timeZoneOffset = 0;
        }

        int newTime=(int)(timeZoneOffset * 60 * 60 * 1000);
        TimeZone timeZone;
        String[] ids = TimeZone.getAvailableIDs(newTime);
        if (ids.length == 0) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = new SimpleTimeZone(newTime, ids[0]);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(timeZone);
        return sdf.format(new Date());
    }

    public static String getCurrentTime(String timeZone){                          //获取指定格式的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));    //指定时区
        return  sdf.format(Calendar.getInstance().getTime());
    }

    public static void main(String[] args) {
        String timeZone = getTimeZone();
        System.out.println("===timeZone==="+timeZone);

        Calendar cal = Calendar.getInstance();
        TimeZone timeZone2 = cal.getTimeZone();
        System.out.println("===timeZone2.getID()==="+timeZone2.getID());
        System.out.println("===timeZone2.getDisplayName()==="+timeZone2.getDisplayName());
        TimeZone timeZone3 = TimeZone.getDefault();
        System.out.println("===timeZone3.getID()==="+timeZone3.getID());
        System.out.println("===timeZone3.getDisplayName()==="+timeZone3.getDisplayName());

        String dateString = getDateString(timeZone2.getID());
        System.out.println("===dateString==="+dateString);

        String dateString2 = getFormatedDateString(Integer.valueOf(timeZone));
        System.out.println("===dateString2==="+dateString2);

        String currentTime = getCurrentTime("Europe/London");
        System.out.println("===currentTime==="+currentTime);



        //<1> 查看当前的时区
        ZoneId defaultZone = ZoneId.systemDefault();
        System.out.println("===defaultZone==="+defaultZone); //此处打印为时区所在城市Asia/Shanghai
        //<2>查看美国纽约当前的时间
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime shanghaiTime = LocalDateTime.now(america);
        System.out.println("===shanghaiTime==="+shanghaiTime);

        System.out.println("===LocalDate.now()==="+LocalDate.now());
        System.out.println("===LocalTime.now()==="+LocalTime.now());
        System.out.println("===LocalDateTime.now()==="+LocalDateTime.now());
        System.out.println("===Instant.now()==="+ Instant.now());


        //将java.util.Date转换为Instant
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println("===instant==="+instant);
        //从字符串类型中创建Instant类型的时间
        instant = Instant.parse("1995-10-23T10:12:35Z");
        System.out.println("===instant==="+instant);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        System.out.println("===localTime==="+localTime);
        LocalDateTime ldt = LocalDateTime.parse("2018-01-12 17:07:05",df);
        System.out.println("===ldt==="+ldt);


        LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        LocalDateTime end = LocalDateTime.of(2020, 1, 9, 19, 25, 30);
        Duration d = Duration.between(start, end);
        System.out.println(d); // PT1235H10M30S

        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
        System.out.println(p); // P1M21D
    }
}
