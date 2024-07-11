package Annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

//Ԫע��ֻ����Ϊע�����ע��

@TestTarget(value = "tb_student")
//ע�����Ѿ���д��Ԫע��Ϊ��������ʱ�ɷ����ã������ڷ�����
@TestRetention
public class AnnotationTry {
	@TestRetention

	 @TestTargetField(columnname="id",type="int",length=10)
	 private int id;
	 @TestTargetField(columnname="name",type="v archar",length=10)
	private String name;
	 @TestTargetField(columnname="sge",type="int",length=10)
	private int age;
public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
	Class clazz=Class.forName("Annotation.AnnotationTry");
	Annotation[] ts=clazz.getAnnotations();
	Annotation t=(Target) clazz.getAnnotation(Target.class);
	for(Annotation temp:ts) {
		System.out.println(temp);
	}
	System.out.println(t);
	Field f=clazz.getDeclaredField("id");
	TestTargetField ttf=f.getAnnotation(TestTargetField.class);
	System.out.println(ttf.columnname()+ttf.type()+ttf.length());
}
}
