package Base.面向对象相关;
//封装继承多态final
public class 封装继承多态 {
	public static void main(String[] args) {
		fatherr f=new fatherr();
		shout(f);
		son1 s=new son1();
		shout(s);
//		父类引用子类对象，调用被子类重写的方法
//		这里实现了多态，父类对象使用子类构造方法，并调用子类父类共有的方法
		fatherr ff=new son1();//父类调用子类的构造方法，自动类型转换,但实际仍为子类对象
		ff.method();//输出son1，因为父类的该方法被子类重写了
		ff.method1();// 输出father1，说明可以调用父类方法
//		son1 ss=(son1)new fatherr();//子类调用父类的构造方法，必须强制类型转换，但运行时会报错
//		ss.method();
		
	}
	static void shout(fatherr a) {
		a.method();
	}
}
//final修饰的类不可继承，修饰的方法不可重写，修饰的对象不能被修改
class fatherr{
	public void method() {
		System.out.println("father");
	}
	public void method1() {
		System.out.println("father1");
	}
}
//子类继承父类
class son1 extends fatherr{
	//子类重写父类中的方法
	public void method() {
		System.out.println("son1");
	}
	public void method2() {
		System.out.println("son11");
	}
}
class son2 extends fatherr{
	public void method() {
		System.out.print("son2");
	}
}
