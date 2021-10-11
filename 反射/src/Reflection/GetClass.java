package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetClass {
public static void main(String[] args) {
	try {
		String path="Reflection.Test1";
//		增加泛型和强转,获得类的Class对象
		Class<Test1> c=(Class<Test1>) Class.forName(path);
//		JDK9新方法,先获得类的Class对象,获得其构造器,再用获得的构造器实例化
		Test1 t=c.getConstructor(String.class,int.class).newInstance("kkk",7);
//		使用类的Class对象newInstance()方法,调用其无参构造方法实例化对象
		Test1 t1=c.newInstance();
//		直接获得带参构造方法的Class对象
		Constructor<Test1> con=c.getDeclaredConstructor(String.class,int.class);
		Test1 t2=con.newInstance("李",11);
//		这里比较难记,是对类的class对象操作获得Method对象,输入参数为方法名称和方法参数类型
//		因为这个方法是非静态方法,所以invoke时需要一个类对象,这个类对象通过获得类的Class对象,再用无参构造方法获得
		Method m=c.getDeclaredMethod("hhh", String.class);
		m.invoke(t1, "哈哈哈");
		Field f=c.getDeclaredField("name");
//		下面这行可以把私有的成员变量取消安全检查
//		即使是public修饰使用setAccessible也会产生效果,会减少运行所需要的时间
		f.setAccessible(true);
		f.set(t1, "jjj");
		Method mm=c.getDeclaredMethod("getName",null);
		mm.invoke(t1, null);
		System.out.println(t1.getName());
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchFieldException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
