package Map���;

import java.util.HashMap;
import java.util.Map;
//Map,��ֵ��
public class ��ֵ�� {
public static void main(String[] args) {
	Map<Integer, String> m1=new HashMap<Integer, String>();
//	ֵ�����ظ������������ظ�
//	ֵ�ظ��ˣ��µĻḲ�Ǿɵģ��ж��Ƿ�һ����ͨ��eauals����
	m1.put(1, "one");
	m1.put(2,"two");
	System.out.println(m1.isEmpty());
	System.out.println(m1.containsKey(2));
	System.out.println(m1.size());
	System.out.println(m1.containsValue("two"));
	
	
	Student s1=new Student("������",18,"male");
	Map<Integer,Student> m2=new HashMap<Integer, Student>();
	m2.put(1001, s1);
	System.out.println(m2.get(1001).name);
}
}
class Student{
	String name;
	int age;
	String sex;
	public Student(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
}