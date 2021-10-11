package 面向对象相关;
public class 抽象类与抽象方法 {
public static void main(String[] args) {
//	抽象类的静态成员变量可以直接被静态方法调用
	System.out.println(pp11.i);
}
}
//有抽象方法的类只能定义为抽象类，不能被实例化
//抽象类可以包含属性，类，构造方法，可以有构造方法，但构造方法不能直接用new实例化
//抽象类只能被继承，而且必须实现抽象方法
abstract class  pp11{
	private final static int k=10;
	void qq() {
		System.out.println("哈哈哈");
	}
    abstract void pp();
	abstract void rr();
	static int i=1;
	public pp11() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
class sp11 extends pp11{
	@Override
	void rr() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void pp() {
		// TODO Auto-generated method stub
		System.out.println("hhh");
	}
	public  sp11() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}