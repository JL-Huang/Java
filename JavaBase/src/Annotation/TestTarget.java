package Annotation;
//Ԫע�⣺��ע�����ע��
//@Target:��������ע���ʹ�÷�Χ��ȡֵPACKAGE(��),TYPE(�࣬�ӿڣ�ö�٣�Annotation)��
//CONSTRUCTOR(������)��FIELD(��)��METHOD(����)��LOCAL_VARIABLE(�ֲ�����)��PARAMETER(����)
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestTarget {
//	ֻ��һ������ͨ������Ϊvalue
	String value() /*default ""*/;
}

