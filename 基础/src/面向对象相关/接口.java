package 面向对象相关;
//接口
public class 接口 {
public static void main(String[] args) {
	//一个接口对象可以用一个实现了该接口的类来定义，该类包含了它所实现的所有接口方法
	jiekou3 jf1=new pp12();
	//实现接口方法的其中一种
	jf1.jiekoufangfa3();
}
//接口的常用方法，里面的变量默认为常量，方法默认为抽象方法
//类没有多继承，但接口有多继承
//接口默认是public，static，final修饰
//打个比方，接口的方法是飞，那调用接口的类重写飞的方法，就能是飞机飞，翅膀飞等等
}
interface jiekou1{
	int j1=1;
	void jiekoufangfa1();
	
}
interface jiekou2{
	int j2=2;
	void jiekoufangfa2();
}
interface jiekou3 extends jiekou1,jiekou2{
	int j3=1;
	void jiekoufangfa3();
}
//一个类实现了接口，就必须实现这个接口的所有方法
class pp12 implements jiekou3{

	@Override
	public void jiekoufangfa1() {
		// TODO Auto-generated method stub
		System.out.println("method1");
	}

	@Override
	public void jiekoufangfa2() {
		// TODO Auto-generated method stub
		System.out.println("method2");
	}

	@Override
	public void jiekoufangfa3() {
		// TODO Auto-generated method stub
		System.out.println("method3");
	}
	
	
}