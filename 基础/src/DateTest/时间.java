package DateTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class ʱ�� {
public static void main(String[] args) throws ParseException {
	System.out.println( "��\tһ\t��\t��\t��\t��\t��");
	String str=new String("2020-01-14");
	DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	Date date=df.parse(str);
	Calendar calendar=new GregorianCalendar();
	calendar.setTime(date);

	int days=calendar.get(Calendar.DAY_OF_MONTH);
	int maxday=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	//��iС�ڵ��ڵ�ǰDAY_OF-WEEKʱ������ո񣬵�ǰ������һ��DAY_OF-WEEK=1�������һ���ո�
	for(int i=0;i<calendar.get(Calendar.DAY_OF_WEEK);i++) {
		System.out.print("\t");
	}
	for(int i=1;i<=maxday;i++) {
		calendar.add(Calendar.DAY_OF_MONTH,1);
//		����������
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
