package com.allen.dayup.thinkinjava.date;

/**
 * @Auther: 20190598
 * @Date: 2019/10/25 16:07
 * @Description:
 */
public class DateDemo {

    public static void main(String[] args) {

        //LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.of("GMT+05:00"));
        //ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("GMT+08:00"));
        //System.out.println(localDateTime);
        //System.out.println(zonedDateTime);

        //时区时间
        //ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        //ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York")); // 用指定时区获取当前时间
        //System.out.println(zbj);
        //System.out.println(zny);


        //Duration d1 = Duration.ofHours(10); // 10 hours
        //Duration d2 = Duration.parse("P1DT2H3M"); // 1 day, 2 hours, 3 minutes
        //System.out.println(d1);
        //System.out.println(d2);

        //时间比较
        //LocalDateTime now = LocalDateTime.now();
        //LocalDateTime target = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        //System.out.println(now.isBefore(target));
        //System.out.println(LocalDate.now().isBefore(LocalDate.of(2019, 11, 19)));
        //System.out.println(LocalTime.now().isAfter(LocalTime.parse("08:15:00")));


        ////时间运算获取一些特定时间日期
        //// 本月第一天0:00时刻:
        //LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        //System.out.println(firstDay);
        //
        //// 本月最后1天:
        //LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        //System.out.println(lastDay);
        //
        //// 下月第1天:
        //LocalDate nextMonthFirstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        //System.out.println(nextMonthFirstDay);
        //
        //// 本月第1个工作日:
        //LocalDate firstWeekday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        //System.out.println(firstWeekday);
        //
        ////本月第一后周日
        //LocalDate firstSunday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
        //System.out.println(firstSunday);


        //时间加减
        //LocalDateTime dt = LocalDateTime.of(2019, 10, 31, 20, 30, 59);
        //System.out.println(dt);
        //// 加5天减3小时:
        //LocalDateTime dt2 = dt.plusDays(5).minusHours(3);
        //System.out.println(dt2); // 2019-10-31T17:30:59
        // //减1月
        //LocalDateTime dt3 = dt2.minusMonths(1);
        //System.out.println(dt3); // 2019-09-30T17:30:59


        // 自定义格式化:
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //System.out.println(dtf.format(LocalDateTime.now()));
        //
        //// 用自定义格式解析:
        //LocalDateTime dt2 = LocalDateTime.parse("2019/11/30 15:16:17", dtf);
        //System.out.println(dt2);



        //注意ISO 8601规定的日期和时间分隔符是T。标准格式如下：
        //
        //日期：yyyy-MM-dd
        //时间：HH:mm:ss
        //带毫秒的时间：HH:mm:ss.SSS
        //日期和时间：yyyy-MM-dd'T'HH:mm:ss
        //带毫秒的日期和时间：yyyy-MM-dd'T'HH:mm:ss.SSS


        //str to date
        //LocalDate localDate = LocalDate.parse("2110-11-23");
        //LocalDateTime localDateTime = LocalDateTime.parse("2012-10-25T10:09:31"); //ISO 8601标准格式
        //System.out.println(localDate);
        //System.out.println(localDateTime);

        //创建指定的时间和日期
        //LocalDate localDate = LocalDate.of(2019,9, 12);
        //LocalTime localTime = LocalTime.of(12, 5, 1);
        //LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
        //
        //System.out.println(localDate);
        //System.out.println(localTime);
        //System.out.println(localDateTime);

        //日期时间的转换
        //LocalDateTime dt = LocalDateTime.now();
        //LocalDate d = dt.toLocalDate();
        //LocalTime t = dt.toLocalTime();
        //System.out.println(d);
        //System.out.println(t);
        //System.out.println(dt);

        //java8 time
        //LocalDate d = LocalDate.now(); //当前日期
        //LocalTime t = LocalTime.now(); //当前时间
        //LocalDateTime dt = LocalDateTime.now(); //本地时间
        //
        //System.out.println(d);
        //System.out.println(t);
        //System.out.println(dt);


        ////TimeZone
        //for (String availableID : TimeZone.getAvailableIDs()) {
        //    System.out.print(availableID + " ");
        //}
        //System.out.println("---------------");
        //TimeZone timeZone = TimeZone.getDefault(); //当前市区
        //TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00"); //GMT+9:00时区
        //TimeZone tzNy = TimeZone.getTimeZone("America/New_York");
        //System.out.println(timeZone);
        //System.out.println(tzGMT9);
        //System.out.println(tzNy);

        //Calendar转换时区


        ////Date获取当前时间
        //Date date = new Date();
        //
        //System.out.println(date.getYear() );
        //System.out.println(date.getMonth());
        //System.out.println(date.getDate() );
        //
        //System.out.println(date.toString());
        //System.out.println(date.toGMTString());

        ////Calendar获取当前时间
        //Calendar calendar = Calendar.getInstance();
        //
        //int year = calendar.get(Calendar.YEAR);
        //int month = calendar.get(Calendar.MONTH) + 1;
        //int day = calendar.get(Calendar.DAY_OF_MONTH);
        //int hour = calendar.get(Calendar.HOUR_OF_DAY);
        //int mm = calendar.get(Calendar.MINUTE);
        //int ss = calendar.get(Calendar.SECOND);
        //int ms = calendar.get(Calendar.MILLISECOND);
        //
        //System.out.println(year + "-" + month + "-" + day + " " + hour + ":" + mm + ":" + ss + "." + ms);

    }
}
