package ArrayTest;
//��װ��
public class p16 {
public static void main(String[] args) {
//	abc��ΪInteger����
	Integer a=new Integer(1);
	Integer b=Integer.valueOf(2);
	Integer c=Integer.valueOf("3");
//	��Integer����ת��Ϊint��double
	int d=b.intValue();
	double e=c.doubleValue();
	Object[] f= {a,b,c,d,e};
	for(Object temp:f) {
		System.out.println(temp);
	}
	Integer g=new Integer("4");
//	StringתΪInteger
	Integer h=Integer.parseInt("15");
	System.out.println(h);
//	IntegerתΪString
	String i=h.toString();
	System.out.println(i);
//	�Զ�װ�䣬���Զ�����Integer.valueOf()����
	Integer j=100;
//	�Զ����䣬���Զ�����j.intvalue()����
	int k=j;
	Integer l=null;
//	int m=l;����ָ�����
//	ԭ����lΪ�գ�ȴ������l�ķ���
	Integer m=-128;
	Integer n=-128;
//	����true����Ϊ-128��127���������ڻ����������Ǵӻ�����������ȡ�����Ѿ�����õĳ�������
	System.out.println(m==n);
	Integer o=1234;
	Integer p=1234;
//	����false����Ϊ1234���ǻ������飬ʹ��ʱ��Ҫ�½�������ͬ�Ķ���
	System.out.println(o==p);
}
}
