package 时间相关;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class 时间 {
public static void main(String[] args) throws ParseException {
	System.out.println( "日\t一\t二\t三\t四\t五\t六");
	String str=new String("2020-01-14");
	DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	Date date=df.parse(str);
	Calendar calendar=new GregorianCalendar();
	calendar.setTime(date);

	int days=calendar.get(Calendar.DAY_OF_MONTH);
	int maxday=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	//当i小于等于当前DAY_OF-WEEK时，输出空格，当前是星期一，DAY_OF-WEEK=1，则输出一个空格
	for(int i=0;i<calendar.get(Calendar.DAY_OF_WEEK);i++) {
		System.out.print("\t");
	}
	for(int i=1;i<=maxday;i++) {
		calendar.add(Calendar.DAY_OF_MONTH,1);
//		这里有问题
//		if(maxday==calendar.get(Calendar.DAY_OF_MONTH)) {
//			System.out.print(i+"\t"+"*");
//		}else {
		System.out.print(i+"\t");
//		}
		if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) {
			System.out.println();
		}
		

	}
	
}
}
