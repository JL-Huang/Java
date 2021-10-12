package Factory;
//�򵥹���ģʽҲ�о�̬����ģʽ����Ϊ�����ķ������Ǿ�̬����
//����²�Ʒ��Ҫ�޸ķǳ���Ĵ���
public class SimpleFactory {
	public static void main(String[] args) {
		Car car1=SimpleCarFactory.createcar("����");
		car1.run();
	}
}
class SimpleCarFactory{
	public static Car createcar(String name) {
		if(name.equals("����")) return new Bwm();
		if(name.equals("����")) return new Benz();
		return null;
	}
}
class Bwm implements Car{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}
	
}
class Benz implements Car{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}
	
}
interface Car{
	void run();
}