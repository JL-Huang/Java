package ����������;
//�����ڲ���
public class �ڲ��� {
public static void main(String[] args) {
//	�ڲ������Ķ��巽�����������໹�ǹ��췽�������������ⲿ����ⲿ���췽��
	Outer.Inner inner=new Outer().new Inner();
//	���ڲ�������Ȼ������һ���ⲿ��������Կ�����this
	inner.InnerMethod();
//	�ϴν����ӿ��ǲ���ֱ��new�ģ�����ȴ���ԣ�ԭ����ʹ���������ڲ���
//	�������ڲ���ʵ���˽ӿڣ�Ȼ��new���������
//	�������������ڲ���д���������ǽӿ����汻ע�͵��Ĵ���
	pp13.pp13_1(new Jiekou4() {
		
		@Override
		public void jiekoufangfa4() {
			// TODO Auto-generated method stub
			System.out.println("�����ڲ�������˽ӿ�");
		}
	});
//	��̬�ڲ������Ĵ�������
	ppp13.ppp13_1 jtnbldx=new ppp13.ppp13_1();
	jtnbldx.ppp13_method();
}	
}

//�Ǿ�̬�ڲ���
//�Ǿ�̬�ڲ������ֱ�ӷ����ⲿ��ĳ�Ա�������ⲿ�಻�ܷ���ֱ���ڲ���ĳ�Ա
//�Ǿ�̬�ڲ����в����þ�̬��������̬�����뾲̬��ʼ����
//�ⲿ��ľ�̬���������Է��ʷǾ�̬�ڲ��࣬�����������ڲ��ഴ������
class Outer{
	private int age=10;
	class Inner{
		int age=20;
		public void InnerMethod() {
			int age=30;
//			�����this��ָһ���������ⲿ�����
			System.out.println(Outer.this.age);
//			�����thisָ��������������ڲ������
			System.out.println(this.age);
//			�����ageָ��������ľֲ�����
			System.out.println(age);
		}
	}
}



//�����ڲ���
interface Jiekou4{
	void jiekoufangfa4();
}
//��һ���ǲ�����static���εģ������Ǿ�̬�ڲ��࣬����Ҳ������public���Σ�һ��Java�ļ�ֻ����һ��public��
//class nimingneibulei implements jiekou4{

//	@Override
//	public void jiekoufangfa4() {
		// TODO Auto-generated method stub
//	}
//	}
class pp13{
	static void pp13_1(Jiekou4 jiekou4) {
		jiekou4.jiekoufangfa4();
		
	}
}


//��̬�ڲ���
class ppp13{
	int i=1;
	static class ppp13_1{
		int j=1;
			void ppp13_method() {
//				System.out.println(ppp13.this.i);
				System.out.println(this.j);
				System.out.println("�����˾�̬�ڲ����еķ���");
			
		}
	}
}