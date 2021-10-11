package MyThread;
//静态代理模式
//两个类实现了同一个接口，真实类作为代理类的成员变量，代理类的构造方法参数里加入真实类，接口方法重写为真实类的接口方法
//执行时只需要执行代理类的接口方法
//事实上线程开启就是这样子，Thread是代理类，自定义类为真实类。run为接口方法
//与装饰模式相似，都是两个类同时实现接口，但装饰模式一个类是抽象类，而且是把接口对象而不是接口类实现对象作为成员变量
public class StaticProxy {
public static void main(String[] args) {
	new He(new Me()).happymarry();
}
}

interface Marry{
	void happymarry();
}
class Me implements Marry{
	@Override
	public void happymarry() {
		// TODO Auto-generated method stub
		System.out.println("我结婚");
	}
}
class He implements Marry{
	private Marry taget;
	
	public He(Marry taget) {
		super();
		this.taget = taget;
	}

	@Override
	public void happymarry() {
		// TODO Auto-generated method stub
		this.taget.happymarry();
	}
}