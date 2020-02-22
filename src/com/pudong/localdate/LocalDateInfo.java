/**
 * 
 */
package com.pudong.localdate;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class LocalDateInfo {
	public static void main(String[] args) {
		
		//今天的日期
		LocalDate now = LocalDate.now();
		System.out.println("今天的日期" + now);
		
		//获取年月日
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.println("今天为：" + year + "年" +month+ "月" +day+"日");
		
		//获取特定日期
		LocalDate impotantDay = LocalDate.of(2018, 3, 4);
		System.out.println(impotantDay);
		
		
		//判断两个日期是否相等
		LocalDate equeslDate = LocalDate.now();
		LocalDate equeslqDate2 = LocalDate.of(2020, 2, 22);
		System.out.println(equeslDate.equals(equeslqDate2) ? "时间相等":"时间不等");
		
		//检查生日这种周期事件
		LocalDate date = LocalDate.now();
		LocalDate date2 = LocalDate.of(2020, 2, 22);
		MonthDay birthday = MonthDay.of(date2.getMonth(), date2.getDayOfMonth());
		MonthDay currentMonthbirthDay = MonthDay.from(date);
		System.out.println(birthday.equals(currentMonthbirthDay) ? "生日到了": "还没到呢");
		
		//获取当前时间
		LocalTime localTime = LocalTime.now();
		System.out.println("获取当前时间,不包含有日期: " + localTime);
		
		//获取三小时之后的时间
		LocalTime time = LocalTime.now();
		LocalTime plusHours = time.plusHours(3);
		System.out.println("三小时之后的时间为： " + plusHours);
		
		//计算一周之后的时间
		LocalDate nowTime = LocalDate.now();
		System.out.println("今天时间为： " +nowTime);
		LocalDate nextweek = nowTime.plus(1,ChronoUnit.WEEKS);
		System.out.println("一周之后的日期为： " + nextweek);
		
		//计算一年之前或者之后的时间
		LocalDate nowtime2 = LocalDate.now();
		LocalDate year2 = nowtime2.minus(1,ChronoUnit.YEARS);
		LocalDate year3 = nowtime2.plus(1,ChronoUnit.YEARS);
		System.out.println("一年之后的时间： " + year3 + "  一年之前的时间 ： " + year2);
		
		//clock时钟类
		Clock clock = Clock.systemUTC();
		System.out.println("clock: " + clock.millis());
		
		Clock clock2 = Clock.systemDefaultZone();
		System.out.println("clock2: "+ clock2.millis());
		
		//判断一个日期是早于还是晚于另一个日期
		LocalDate localDate2 = LocalDate.now();
		LocalDate of = LocalDate.of(2018, 3, 4);
		System.out.println(localDate2.isAfter(of) ?"晚于":"早于");
		
		LocalDate minus = localDate2.minus(1,ChronoUnit.DAYS);
		System.out.println(minus);
		System.out.println(localDate2.isBefore(minus) ? "晚于" :"早于");
		
		//处理时区
		ZoneId of2 = ZoneId.of("America/New_York");
		LocalDateTime of3 = LocalDateTime.now();
		ZonedDateTime of4 = ZonedDateTime.of(of3,of2);
		System.out.println("curren date and time in a particular timezone: " + of4);
		
		//表示信用卡到期这类信息
		YearMonth yearMonth = YearMonth.now();
		System.out.printf("Day in month year %s: %d%n ",yearMonth,yearMonth.lengthOfMonth());
		YearMonth of5 = YearMonth.of(2019, Month.FEBRUARY);
		System.out.printf("Your credit card expires on %s %n",of5);
		
		//检查闰年
		LocalDate of6 = LocalDate.now();
		System.out.println(of6.isLeapYear() ? "闰年": "平年");
		
		//检查两个日期的天数和月数
		LocalDate of7 = LocalDate.now();
		LocalDate of8 = LocalDate.of(2010, 2, 23);
		Period between = Period.between(of7, of8);
		System.out.println("Months left between of7 and java 8 release : " + between.getMonths());
		
		//获取当前的时间戳
		Instant instant = Instant.now();
		System.out.println("What is value of this instant : " + instant.toEpochMilli());
		
		//如何使用预定义的格式化工具去分析或格式化日期
		String dayAfterTomorrow = "20380918";
		LocalDate parse = LocalDate.parse(dayAfterTomorrow,DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(dayAfterTomorrow + " 格式化的日期为： " +parse);
		
		//字符串互转日期类型
		LocalDateTime lei = LocalDateTime.now();
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String format = lei.format(ofPattern);
		System.out.println("日期转化为字符串： " + format);
		
		DateTimeFormatter ofPattern2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDate parse2 = LocalDate.parse(format,ofPattern2);
		System.out.println("日期类型为： " + parse2);
	}
	public void nextweek() {
		
	}
	
}
