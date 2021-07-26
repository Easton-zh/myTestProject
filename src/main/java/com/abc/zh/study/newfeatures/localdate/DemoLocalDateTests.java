package com.abc.zh.study.newfeatures.localdate;

import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.format.DateTimeFormatter;

@SpringBootTest(classes = DemoLocalDateTests.class)
public class DemoLocalDateTests {

    /**
     * Instant：瞬时实例
     * LocalDate：本地日期 不包含具体时间 例如 2020-02-02 可以用来记录纪念日
     * LocalDTime：本地时间 不包含日期
     * LocalDateTime：结合了日期和时间 但不包含时差和时区
     * ZonedDateTime：完整的日期时间，包含时区和相对UTC或格林威治的视察
     *
     * ZoneOffSet,ZoneId：操作时区
     *
     * DateTimeFormatter:格式化时间
     *
     * LocalDate等许多类为 final 线程安全不可变， plusHour withDay等操作后要用新的对象来接收
     */
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today); // 2021-06-01

        /* 处理特定日期  */
        LocalDate birthday = LocalDate.of(1995,10,26);
        System.out.println(birthday); // 1994-08-11

        /* 日期比较  */
        if (today.equals(birthday)) {
            System.out.println("日期形同");
        }else {
            System.out.println("日期不同");
        }

        /* MonthDay 和 YearMonth 用来检查某一天是不是生日这种周期性时间 */
        MonthDay myBithday = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
        MonthDay currentMonDay = MonthDay.from(today);
        if (myBithday.equals(currentMonDay)) {
            System.out.println("今天是你的生日");
        }

        /* 在现有时间基础上囧算之前之后的年、月、周、时、分、秒 */
        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime afterTime = nowTime.plusHours(3);
        LocalDateTime beforeTime = nowTime.minusYears(2);
        System.out.println("afterTime:"+afterTime+"- beforeTime:"+beforeTime);
        // afterTime:2020-05-30T15:09:28.013- beforeTime:2018-05-30T12:09:28.013


        /* 在现有时间基础上修改年、月、周、时、分、秒 */
        LocalDateTime localDateTime = nowTime.withHour(11);
        System.out.println("with 11 Time:"+localDateTime); // with 11 Time:2020-05-30T11:09:28.013


        /* 使用java8的Clock时钟类获取时间戳 */
        Clock clock = Clock.systemUTC();
        System.out.println("时钟类获取时间戳："+clock.millis()); // 1590811768013
        System.out.println("系统获取时间戳："+System.currentTimeMillis()); // 1590811768013

        Clock defalutClock = Clock.systemDefaultZone();
        System.out.println(defalutClock.millis()); // 1590811768013
        System.out.println(defalutClock.getZone()); // Asia/Shanghai


        /* 判断早于某时还是晚于某时 */
        LocalDateTime tomorrow = nowTime.plusDays(1);
        System.out.println("LocalDateTim： "+tomorrow);
        System.out.println("++++++++++时间比较+++++++++");
        if (tomorrow.isEqual(nowTime)) {
            System.out.println("时间一样");
        } else if (tomorrow.isAfter(nowTime)) {
            System.out.println("当前时间之后");
        } else if (tomorrow.isBefore(nowTime)) {
            System.out.println("当前时间之前");
        } else {
            System.out.println("错误比较");
        }

        /* 时区处理 */
        ZoneId beijing = ZoneId.of("America/New_York");
        LocalDateTime timenow = LocalDateTime.now();

        ZonedDateTime zonedDateTime = ZonedDateTime.of(timenow, beijing);
        System.out.println("纽约时间" + zonedDateTime);
        // 纽约时间2020-05-30T12:22:38.102-04:00[America/New_York]


        /* 检测闰年 */
        LocalDate leafYear = LocalDate.now();
        if (leafYear.isLeapYear()){
            //闰年
        }

        /* 计算两个时间之间的天数和月数 */
        LocalDate current = LocalDate.now();
        LocalDate yourBirthday = LocalDate.of(1996, 8, 11);
        Period between = Period.between(yourBirthday, current);
        System.out.println(between.getYears()+"年"+between.getMonths()+"月"+between.getDays()+"天");
        // 23年9月19天

        /* 包含时差信息的日期和时间
         *  ZoneOffset 表示时差 印度与GMT或者UTC飙车事件时差+5:30
         * */
        LocalDateTime dateTime = LocalDateTime.now();
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(dateTime, offset);
        System.out.println(offsetDateTime); //2020-05-30T12:48:54.655+05:30
        System.out.println(OffsetDateTime.now()); //2020-05-30T12:48:54.655+08:00

        /* 格式化时间 */

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(LocalDateTime.now()));//2020-05-30 12:55:40

    }
}
