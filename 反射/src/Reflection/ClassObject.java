package Reflection;

public class ClassObject {
public static void main(String[] args) throws ClassNotFoundException {
	 String path="Reflection.Test";
//	 �������ʱ�ͻ��ڷ�������Ÿ�������ݽṹ��Ȼ���ڶ��н�������������Class����
//	 �������ľ��Ǹ��ݸ����·������������ʱ�ڶ��е�Class����
//	 ע����Class������class
	 Class c1=Class.forName(path);
	 System.out.println(c1);
//	 ע��,���ﷵ�ص���String�����,ÿ��������ʵ����֮�󶼻�����������Ϣ�����ԶԸñ�������getclass()
	 Class c1_1=path.getClass();
	 System.out.println(c1_1);
//	 ���String���Class����
	 Class c2=String.class;
	 System.out.println(c2);
//	 int�����ǲ���getClass�ģ�����Integer����,���߲�����һ����������ϣ�벻һ��
	 Integer c3=5;
	 System.out.println(c3.getClass().hashCode());
	 System.out.println(int.class.hashCode());
	 String[] c4=new String[2];
	 String[] c5=new String[3];
	 String[][] c6=new String[2][3];
	 System.out.println(c2.getClass().hashCode());
//	 ���Կ���,ͬһ��ά�ȵ����飬��Class����ͬ�ģ���ʹ���Ȳ�ͬ
	 System.out.println(c4.getClass().hashCode());
	 System.out.println(c5.getClass().hashCode());
	 System.out.println(c6.getClass().hashCode());
}
}
class Test{
	private String name;
	private int age;
	public Test(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}