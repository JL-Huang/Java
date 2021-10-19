package 现在的理解.单例模式;

public class StaticInnerClass {
	public static void main(String[] args) {
		StaticInnerClass staticInnerClass=StaticInnerClass.getinstance();
	}
	private StaticInnerClass() {}
//	加载时会加载外部类，但是内部类不会被加载，内部类是new的时候才开始加载的
	private static class Inner {
//	这种方法好处在于，当外部类被加载时不会马上加载内部类，当getinstance才会开始加载内部类，而且能在不做任何声明的
//	情况下保证线程安全，因为多个线程同时去初始化一个类，只有一个会被执行，其他线程阻塞，而且只会被初始化一次
//	注意初始化不同于创建对象，这是类的加载时的操作
//	但是也有不好的地方,就是getinstance不能输入参数
		private static StaticInnerClass instance=new StaticInnerClass();
	}
//	注意，外部类无法直接调用内部类的成员变量，设为静态可以通过声明类获得
	public static StaticInnerClass getinstance() {
		return Inner.instance;
	}
}
