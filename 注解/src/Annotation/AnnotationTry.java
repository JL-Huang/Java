package Annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

//元注解只能作为注解类的注解

@TestTarget(value = "tb_student")
//注解是已经是写好元注解为可在运行时由反射获得，才能在反射获得
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
