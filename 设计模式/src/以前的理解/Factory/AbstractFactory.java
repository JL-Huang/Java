package 以前的理解.Factory;
//抽象工厂模式：不可增加产品，可增加产品族
public class AbstractFactory {
public static void main(String[] args) {
	Engine e1=new LuxuryFactory().createengine();
	e1.run();
}
}
interface Engine{
	void run();
}
interface Seat{
	void feel();
}
class LuxuryEngine implements Engine{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("跑得快");
	}
}
class LowEngine implements Engine{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	System.out.println("跑得慢");	
	}
}
class LuxurySeat implements Seat{
	@Override
	public void feel() {
		// TODO Auto-generated method stub
	System.out.println("很舒服");	
	}
}
class LowSeat implements Seat{
	@Override
	public void feel() {
		// TODO Auto-generated method stub
	System.out.println("不舒服");	
	}
}
interface ItemFactory{
	Engine createengine();
	Seat createseat();
}
class LuxuryFactory implements ItemFactory{
	@Override
	public Engine createengine() {
		// TODO Auto-generated method stub
		return new LuxuryEngine();
	}@Override
	public Seat createseat() {
		// TODO Auto-generated method stub
		return new LuxurySeat();
	}
}
class LowFactory implements ItemFactory{
	@Override
	public Engine createengine() {
		// TODO Auto-generated method stub
		return new LowEngine();
	}
	@Override
	public Seat createseat() {
		// TODO Auto-generated method stub
		return new LowSeat();
	}
}
