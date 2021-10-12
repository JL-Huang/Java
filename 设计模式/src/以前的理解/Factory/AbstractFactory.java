package ��ǰ�����.Factory;
//���󹤳�ģʽ���������Ӳ�Ʒ�������Ӳ�Ʒ��
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
		System.out.println("�ܵÿ�");
	}
}
class LowEngine implements Engine{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	System.out.println("�ܵ���");	
	}
}
class LuxurySeat implements Seat{
	@Override
	public void feel() {
		// TODO Auto-generated method stub
	System.out.println("�����");	
	}
}
class LowSeat implements Seat{
	@Override
	public void feel() {
		// TODO Auto-generated method stub
	System.out.println("�����");	
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