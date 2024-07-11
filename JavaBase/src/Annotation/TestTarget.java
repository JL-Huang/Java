package Annotation;
//元注解：对注解进行注解
//@Target:用于描述注解的使用范围，取值PACKAGE(包),TYPE(类，接口，枚举，Annotation)，
//CONSTRUCTOR(构造器)，FIELD(域)，METHOD(方法)，LOCAL_VARIABLE(局部变量)，PARAMETER(参数)
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestTarget {
//	只有一个参数通常定义为value
	String value() /*default ""*/;
}

