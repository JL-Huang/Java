package 面向对象相关;
//关于内部类
public class 内部类 {
public static void main(String[] args) {
//	内部类对象的定义方法，无论是类还是构造方法都得先声明外部类或外部构造方法
	Outer.Inner inner=new Outer().new Inner();
//	有内部类对象必然隐含了一个外部类对象，所以可以用this
	inner.InnerMethod();
//	上次讲到接口是不能直接new的，这里却可以，原因是使用了匿名内部类
//	该匿名内部类实现了接口，然后new的是这个类
//	如果把这个匿名内部类写出来，就是接口下面被注释掉的代码
	pp13.pp13_1(new Jiekou4() {
		
		@Override
		public void jiekoufangfa4() {
			// TODO Auto-generated method stub
			System.out.println("匿名内部类调用了接口");
		}
	});
//	静态内部类对象的创建方法
	ppp13.ppp13_1 jtnbldx=new ppp13.ppp13_1();
	jtnbldx.ppp13_method();
}	
}

//非静态内部类
//非静态内部类可以直接访问外部类的成员，但是外部类不能访问直接内部类的成员
//非静态内部类中不能用静态方法，静态属性与静态初始化块
//外部类的静态方法不可以访问非静态内布类，包括不能用内部类创建对象
class Outer{
	private int age=10;
	class Inner{
		int age=20;
		public void InnerMethod() {
			int age=30;
//			这里的this代指一个隐含的外部类对象
			System.out.println(Outer.this.age);
//			这里的this指调用这个方法的内部类对象
			System.out.println(this.age);
//			这里的age指方法里面的局部变量
			System.out.println(age);
		}
	}
}



//匿名内部类
interface Jiekou4{
	void jiekoufangfa4();
}
//类一般是不能用static修饰的，除非是静态内部类，这里也不能用public修饰，一个Java文件只能有一个public类
//class nimingneibulei implements jiekou4{

//	@Override
//	public void jiekoufangfa4() {
		// TODO Auto-generated method stub
//	}
//	}
class pp13{
	static void pp13_1(Jiekou4 jiekou4) {
		jiekou4.jiekoufangfa4();
		
	}
}


//静态内部类
class ppp13{
	int i=1;
	static class ppp13_1{
		int j=1;
			void ppp13_method() {
//				System.out.println(ppp13.this.i);
				System.out.println(this.j);
				System.out.println("调用了静态内部类中的方法");
			
		}
	}
}
