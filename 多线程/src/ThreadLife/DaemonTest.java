package ThreadLife;
//�߳�Ĭ�����û��߳�
//JVM����������û��߳�ִ�������ֹͣ
public class DaemonTest {
public static void main(String[] args) {
	Thread t=new Thread(new Alien());
//	Ҫ��Ϊ�ػ��߳�һ��Ҫ���߳̿�ʼǰ����
	t.setDaemon(true);
//	���Կ���,Human���е�100,Alien����ֹͣ����
	t.start();
	new Thread(new Human()).start();
}
}
class Human implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			System.out.println("����"+i);	
		}

	}
}
class Alien implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	for(int i=0;i<1000;i++) {
		System.out.println("������"+i);
	}
	}
}