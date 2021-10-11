package Reflection;

public class ClassObject {
public static void main(String[] args) throws ClassNotFoundException {
	 String path="Reflection.Test";
//	 在类加载时就会在方法区存放该类的数据结构，然后在堆中建立代表这个类的Class对象
//	 现在做的就是根据该类的路径，获得其加载时在堆中的Class对象
//	 注意是Class，不是class
	 Class c1=Class.forName(path);
	 System.out.println(c1);
//	 注意,这里返回的是String类对象,每个变量在实例化之后都会包含其类的信息，可以对该变量进行getclass()
	 Class c1_1=path.getClass();
	 System.out.println(c1_1);
//	 获得String类的Class对象
	 Class c2=String.class;
	 System.out.println(c2);
//	 int类型是不能getClass的，但是Integer可以,两者并不是一个东西，哈希码不一样
	 Integer c3=5;
	 System.out.println(c3.getClass().hashCode());
	 System.out.println(int.class.hashCode());
	 String[] c4=new String[2];
	 String[] c5=new String[3];
	 String[][] c6=new String[2][3];
	 System.out.println(c2.getClass().hashCode());
//	 可以看到,同一个维度的数组，其Class是相同的，即使长度不同
	 System.out.println(c4.getClass().hashCode());
	 System.out.println(c5.getClass().hashCode());
	 System.out.println(c6.getClass().hashCode());
}
}
class Test{
	private String name;
	private int age;
	public Test(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}