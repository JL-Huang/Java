package Factory;
//工厂方法模式
//注意这里有几个类是简单工厂模式已经写好直接用，分别是带有run方法Car接口，继承Car接口的Benz类，继承Car接口的Bwm类
//代码复杂度来说，工厂方法模式更简单，因为增删新的产品只需要删除或添加Car的实现类与CarFactory的实现类
//但从结构复杂来说，简单工厂模式更简单，因为它只需要一个总工厂，不需要每个产品分配一个工厂
//理论上应该采用工厂方法模式，实际一般采用简单工厂模式
public class FactoryMethod {
	public static void main(String[] args) {
		Car car1=new BenzFactory().createcar();
		car1.run();
	}
}
interface MethodCarFactory{
	Car createcar();
}
class BenzFactory implements MethodCarFactory{
	public Car createcar() {
		return new Benz();
}
}
class BwmFactory implements MethodCarFactory{
	public Car createcar() {
		return new Bwm();
}
}