package Factory;
//简单工厂模式也叫静态工厂模式，因为工厂的方法都是静态方法
//添加新产品需要修改非常多的代码
public class SimpleFactory {
	public static void main(String[] args) {
		Car car1=SimpleCarFactory.createcar("宝马");
		car1.run();
	}
}
class SimpleCarFactory{
	public static Car createcar(String name) {
		if(name.equals("宝马")) return new Bwm();
		if(name.equals("奔驰")) return new Benz();
		return null;
	}
}
class Bwm implements Car{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("开宝马");
	}
	
}
class Benz implements Car{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("开奔驰");
	}
	
}
interface Car{
	void run();
}