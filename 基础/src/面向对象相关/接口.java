package ����������;
//�ӿ�
public class �ӿ� {
public static void main(String[] args) {
	//һ���ӿڶ��������һ��ʵ���˸ýӿڵ��������壬�������������ʵ�ֵ����нӿڷ���
	jiekou3 jf1=new pp12();
	//ʵ�ֽӿڷ���������һ��
	jf1.jiekoufangfa3();
}
//�ӿڵĳ��÷���������ı���Ĭ��Ϊ����������Ĭ��Ϊ���󷽷�
//��û�ж�̳У����ӿ��ж�̳�
//�ӿ�Ĭ����public��static��final����
//����ȷ����ӿڵķ����Ƿɣ��ǵ��ýӿڵ�����д�ɵķ����������Ƿɻ��ɣ����ɵȵ�
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
//һ����ʵ���˽ӿڣ��ͱ���ʵ������ӿڵ����з���
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