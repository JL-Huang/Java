package ThreadLife;
//yield����,��ǰ�ص�����״̬����������״̬,����״̬Ҫ���������״̬����Ҫ�ֶ�����,�ò���ϵͳ����
//ע���Ǿ�̬����,û�ж���,д���ĸ��߳����ĸ��߳̾�����
//���ò����漰����,һ���߳�������ֱ�ӻ�ص�����״̬
public class YieldTest {
public static void main(String[] args) {
	MyYield my=new MyYield();
	new Thread(my,"a").start();
	new Thread(my,"b").start();
	
}
}
class MyYield implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		����yield��,��ִ�е���һ���̵߳Ļص�����״̬,Ȼ����������һ���߳�ִ����"��ʼ"���һ���̲߳�ִ��"����"
	System.out.println("��ʼ"+Thread.currentThread().getName());
	Thread.yield();
	for(int i=0;i<10;i++) {
		System.out.println("����"+Thread.currentThread().getName());
	}

	}
}