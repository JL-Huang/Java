package ����������;
//��װ�̳ж�̬final
public class ��װ�̳ж�̬ {
	public static void main(String[] args) {
		fatherr f=new fatherr();
		shout(f);
		son1 s=new son1();
		shout(s);
//		��������������󣬵��ñ�������д�ķ���
//		����ʵ���˶�̬���������ʹ�����๹�췽�������������ุ�๲�еķ���
		fatherr ff=new son1();//�����������Ĺ��췽�����Զ�����ת��,��ʵ����Ϊ�������
		ff.method();//���son1����Ϊ����ĸ÷�����������д��
		ff.method1();// ���father1��˵�����Ե��ø��෽��
//		son1 ss=(son1)new fatherr();//������ø���Ĺ��췽��������ǿ������ת����������ʱ�ᱨ��
//		ss.method();
		
	}
	static void shout(fatherr a) {
		a.method();
	}
}
//final���ε��಻�ɼ̳У����εķ���������д�����εĶ����ܱ��޸�
class fatherr{
	public void method() {
		System.out.println("father");
	}
	public void method1() {
		System.out.println("father1");
	}
}
//����̳и���
class son1 extends fatherr{
	//������д�����еķ���
	public void method() {
		System.out.println("son1");
	}
	public void method2() {
		System.out.println("son11");
	}
}
class son2 extends fatherr{
	public void method() {
		System.out.print("son2");
	}
}