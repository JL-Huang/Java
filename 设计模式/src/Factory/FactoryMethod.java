package Factory;
//��������ģʽ
//ע�������м������Ǽ򵥹���ģʽ�Ѿ�д��ֱ���ã��ֱ��Ǵ���run����Car�ӿڣ��̳�Car�ӿڵ�Benz�࣬�̳�Car�ӿڵ�Bwm��
//���븴�Ӷ���˵����������ģʽ���򵥣���Ϊ��ɾ�µĲ�Ʒֻ��Ҫɾ�������Car��ʵ������CarFactory��ʵ����
//���ӽṹ������˵���򵥹���ģʽ���򵥣���Ϊ��ֻ��Ҫһ���ܹ���������Ҫÿ����Ʒ����һ������
//������Ӧ�ò��ù�������ģʽ��ʵ��һ����ü򵥹���ģʽ
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