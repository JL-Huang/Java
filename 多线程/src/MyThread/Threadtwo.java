package MyThread;
//��������һ����ʵ��runnable�ӿڣ���дrun����
public class Threadtwo implements Runnable{
//��run����ʵ�ֽ�������
	@Override
	public void run() {
		for(int i=0;i<2;i++) {
			System.out.println("һ������");
		}
		
	}
public static void main(String[] args) {
//	Threadone to=new Threadone();
////	Thread��һ���ǲ���ΪRunnableʵ����Ĺ��췽��
//	Thread t=new Thread(to);
//	t.start();
//	�����̣߳�����ֱ�Ӳ���������
	new Thread(new Threadone()).start();

	for(int i=0;i<20;i++) {
		System.out.println("һ���ô���");
	}
}
}
