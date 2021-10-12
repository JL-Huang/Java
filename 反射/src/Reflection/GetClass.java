package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetClass {
public static void main(String[] args) {
	try {
		String path="Reflection.Test1";
//		���ӷ��ͺ�ǿת,������Class����
		Class<Test1> c=(Class<Test1>) Class.forName(path);
//		JDK9�·���,�Ȼ�����Class����,����乹����,���û�õĹ�����ʵ����
		Test1 t=c.getConstructor(String.class,int.class).newInstance("kkk",7);
//		ʹ�����Class����newInstance()����,�������޲ι��췽��ʵ��������
		Test1 t1=c.newInstance();
//		ֱ�ӻ�ô��ι��췽����Class����
		Constructor<Test1> con=c.getDeclaredConstructor(String.class,int.class);
		Test1 t2=con.newInstance("��",11);
//		����Ƚ��Ѽ�,�Ƕ����class����������Method����,�������Ϊ�������ƺͷ�����������
//		��Ϊ��������ǷǾ�̬����,����invokeʱ��Ҫһ�������,��������ͨ��������Class����,�����޲ι��췽�����
		Method m=c.getDeclaredMethod("hhh", String.class);
		m.invoke(t1, "������");
		Field f=c.getDeclaredField("name");
//		�������п��԰�˽�еĳ�Ա����ȡ����ȫ���
//		��ʹ��public����ʹ��setAccessibleҲ�����Ч��,�������������Ҫ��ʱ��
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
