package DateTest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
//Date
//龙鸣类，只需要知道返回当前时间就是了
//还有就是Date(2020-1990,2,24)表示2020年3月24日
import java.util.Date;
import java.util.GregorianCalendar;

public class 日期 {
public static void main(String[] args) throws ParseException {
	 Date date=new Date();
	 System.out.println(date);
//	 y年份，M月份，w年周数，W月周数，D年天数，d月天数，F月星期数，E星期几
//	 a上下午，H0-23时，k1-24时，K0-11时，h1-12时
//	 m小时分钟数，s分钟秒数，S毫秒，
//	 DateFormat通过SimpleDateFormate定义，参数为其格式，其format方法将日期转为规定格式的字符串
	 DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	 String str=df.format(date);
	 System.out.println(str);
//	 其parse方法可以把字符串变为日期，字符串必须按照格式，注意这里要抛出或者try catch
	 Date da=df.parse("2019-09-01 13-32-34");
	 System.out.println(da);
	 DateFormat df3=new SimpleDateFormat("D");
	 String str3=df3.format(date);
	 System.out.println(str3);
	 
	 Calendar calendar=new GregorianCalendar(2030,04,12,11,12,34);
//	 Calendar.YEAR是抽象类的成员变量，与该抽象类的其他成员变量都可以作为get方法的固定参数
//	 不能直接calendar.year，否则会返回默认值
	 int i=calendar.get(Calendar.YEAR);
//	 设置年份
//	 calendar.set(Calendar.YEAR,1099);
//	 设置日期
//	 calendar.add(Calendar.DATE, 100);
	 System.out.println(i);
//	 日历转日期
	 Date dd=calendar.getTime();
//	 日期转日历
	 calendar.setTime(dd);
		 
	 }
//	 定义打印日历的方法
public void printCalendar(Calendar c) {
	int x=c.get(Calendar.YEAR);
}
}
