package MyThread;
//Lambda���ڼ򻯴��룬�������߳�
public class LambdaTest {
//	��о�̬�ڲ���
//public static void main(String[] args) {
//	new Thread(new MyThread()).start();
//}
//public static class MyThread implements Runnable{
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		System.out.println("һ������");
//	}
//	
//}
	
	
//	��г�Ա�ڲ���
//	public static void main(String[] args) {
//
////		��Ա������Ա���Ա���������г�final������η�
//		class MyThread1 implements Runnable{
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		System.out.println("һ������");
//	}
//			
//		}
//		//˳��ִ�У����Ҫ�����ඨ�����
//		new Thread(new MyThread1()).start();
//	}
	
//	Lambda���ʽ
//	���������ڲ�ֱ���ڲ����ڲ��ù̶���ʽ��ã�jdk8���Լ��Ƶ�����ʵ�ֵ�ʲô�ӿ������ʲô����
//	���������Ļ��ӿ�ֻ����һ������
	public static void main(String[] args) {
//		�Ƶ������һ���ӿ�ʵ���࣬�ڸ����ڲ��Ƶ����˽ӿڵķ���
//		�Ƶ�ʱһ��Ҫ��JDK֪���������Ƶ����ص���ʲô��
		new Thread(()->
		{System.out.println("һ������");}
		).start();
//�ӿڷ����Ĳ������������������ʡ�Բ������ͣ�ֻ��һ�������������Բ�Ҫ���š�ֻ��һ�д���������Ҫ�����źͷֺ�
//		����з���ֵ����ֻ��һ�д��룬����ʡ��return
		J j=/*(int*/ a/*)*/->
//		{
			System.out.println("������"+a)
//			;
//		}
		;
		j.jm(100);
	}
}

interface J{
	void jm(int a);
}

