package ArrayTest;
//包装类
public class p16 {
public static void main(String[] args) {
//	abc均为Integer类型
	Integer a=new Integer(1);
	Integer b=Integer.valueOf(2);
	Integer c=Integer.valueOf("3");
//	将Integer类型转换为int或double
	int d=b.intValue();
	double e=c.doubleValue();
	Object[] f= {a,b,c,d,e};
	for(Object temp:f) {
		System.out.println(temp);
	}
	Integer g=new Integer("4");
//	String转为Integer
	Integer h=Integer.parseInt("15");
	System.out.println(h);
//	Integer转为String
	String i=h.toString();
	System.out.println(i);
//	自动装箱，即自动调用Integer.valueOf()方法
	Integer j=100;
//	自动拆箱，即自动调用j.intvalue()方法
	int k=j;
	Integer l=null;
//	int m=l;报空指针错误
//	原因是l为空，却调用了l的方法
	Integer m=-128;
	Integer n=-128;
//	返回true，因为-128到127的数都存在缓存区，都是从缓存数组中拿取，是已经定义好的常量对象
	System.out.println(m==n);
	Integer o=1234;
	Integer p=1234;
//	返回false，因为1234不是缓存数组，使用时需要新建两个不同的对象
	System.out.println(o==p);
}
}
