package Map相关;

import java.util.HashMap;
import java.util.Map;
//Map,键值对
public class 键值对 {
public static void main(String[] args) {
	Map<Integer, String> m1=new HashMap<Integer, String>();
//	值可以重复，但键不能重复
//	值重复了，新的会覆盖旧的，判断是否一样是通过eauals方法
	m1.put(1, "one");
	m1.put(2,"two");
	System.out.println(m1.isEmpty());
	System.out.println(m1.containsKey(2));
	System.out.println(m1.size());
	System.out.println(m1.containsValue("two"));
	
	
	Student s1=new Student("哈哈哈",18,"male");
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