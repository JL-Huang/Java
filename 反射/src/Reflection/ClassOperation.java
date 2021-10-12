package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassOperation {
public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException {
	String path="Reflection.Test1";
	Class c1=Class.forName(path);
//	���ظ�Class�����·��������
	System.out.println(c1.getName());
//	���ظ�Class���������
	System.out.println(c1.getSimpleName());
//	��ø����public��Ա����
	Field[] fields=c1.getFields();
	System.out.println(fields.length);
//	��ø�������г�Ա����
	Field[] fields1=c1.getDeclaredFields();
	System.out.println(fields1.length);
//	����Ա��������ȡ���ԣ�ע���public�Ļ���Ҫ��getDeclaredField
	Field field2=c1.getDeclaredField("age");
	System.out.println(field2);
//	�����Ĳ�����ȫһ����ֻ����ͨ�����İ�Field����Method�����췽����Field����Constructor
//	ͨ����������������صķ���
	Method method1=c1.getDeclaredMethod("hhh");
	Method method2=c1.getDeclaredMethod("hhh",String.class);
//	������ǣ����صķ���hashcode��Ȼ��һ����,���ǵ�ַ��һ��,����equal�����false
	System.out.println(method1.hashCode());
	System.out.println(method2.hashCode());
	System.out.println(method2.equals(method1));
}
}
class Test1{
	private String name;
	private int age;
	
	public Test1() {
		super();
	}
	public Test1(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void hhh(String str) {
		System.out.println(str);
		
	}
	public void hhh() {
		System.out.println("ddd");
	}
	
}