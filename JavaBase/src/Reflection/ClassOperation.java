package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassOperation {
public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException {
	String path="Reflection.Test1";
	Class c1=Class.forName(path);
//	返回该Class对象的路径加名字
	System.out.println(c1.getName());
//	返回该Class对象的名字
	System.out.println(c1.getSimpleName());
//	获得该类的public成员变量
	Field[] fields=c1.getFields();
	System.out.println(fields.length);
//	获得该类的所有成员变量
	Field[] fields1=c1.getDeclaredFields();
	System.out.println(fields1.length);
//	按成员变量名获取属性，注意非public的还是要用getDeclaredField
	Field field2=c1.getDeclaredField("age");
	System.out.println(field2);
//	方法的操作完全一样，只是普通方法的把Field换成Method，构造方法把Field换成Constructor
//	通过输入参数区别重载的方法
	Method method1=c1.getDeclaredMethod("hhh");
	Method method2=c1.getDeclaredMethod("hhh",String.class);
//	神奇的是，重载的方法hashcode居然是一样的,但是地址不一样,所有equal结果是false
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
