package MyThread;
//����һ��һ����̳�Thread�࣬thread�����Ѿ�ʵ����runnable�ӿڣ���Ҫ��дrunnable�е�run����
public class Threadone extends Thread{
//	��run��ִ��Ҫ���߳�����еĲ���
@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<2;i++) {
			System.out.println("һ������");	
		}

	}

public static void main(String[] args) {
//	ÿ����һ�����̣߳�����Ҫ�½�һ��������࣬��������������ݣ����޷�������
	Threadone t1=new Threadone();
//	�����������У�������ִ����main�������½���һ�����󣬿����̣߳�Ȼ��main��������ִ�У���һ���߳�Ҳ����ִ��
	t1.start();
//	��������ĳ�run��������ֻ����ͨ�����ĵ��ã��ͱ�������������ô��룬û�п����߳�
	t1.run();
	for(int i=0;i<2;i++) {
		System.out.println("һ���ô���");
	}

}
}
