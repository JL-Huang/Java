package DateTest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
//Date
//�����ֻ࣬��Ҫ֪�����ص�ǰʱ�������
//���о���Date(2020-1990,2,24)��ʾ2020��3��24��
import java.util.Date;
import java.util.GregorianCalendar;

public class ���� {
public static void main(String[] args) throws ParseException {
	 Date date=new Date();
	 System.out.println(date);
//	 y��ݣ�M�·ݣ�w��������W��������D��������d��������F����������E���ڼ�
//	 a�����磬H0-23ʱ��k1-24ʱ��K0-11ʱ��h1-12ʱ
//	 mСʱ��������s����������S���룬
//	 DateFormatͨ��SimpleDateFormate���壬����Ϊ���ʽ����format����������תΪ�涨��ʽ���ַ���
	 DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	 String str=df.format(date);
	 System.out.println(str);
//	 ��parse�������԰��ַ�����Ϊ���ڣ��ַ������밴�ո�ʽ��ע������Ҫ�׳�����try catch
	 Date da=df.parse("2019-09-01 13-32-34");
	 System.out.println(da);
	 DateFormat df3=new SimpleDateFormat("D");
	 String str3=df3.format(date);
	 System.out.println(str3);
	 
	 Calendar calendar=new GregorianCalendar(2030,04,12,11,12,34);
//	 Calendar.YEAR�ǳ�����ĳ�Ա��������ó������������Ա������������Ϊget�����Ĺ̶�����
//	 ����ֱ��calendar.year������᷵��Ĭ��ֵ
	 int i=calendar.get(Calendar.YEAR);
//	 �������
//	 calendar.set(Calendar.YEAR,1099);
//	 ��������
//	 calendar.add(Calendar.DATE, 100);
	 System.out.println(i);
//	 ����ת����
	 Date dd=calendar.getTime();
//	 ����ת����
	 calendar.setTime(dd);
		 
	 }
//	 �����ӡ�����ķ���
public void printCalendar(Calendar c) {
	int x=c.get(Calendar.YEAR);
}
}