package MyThread;
//������ʵ���߳���Դ����
//Ҫע����ǣ������߳�����ͨ������ͬ��runnable��ʵ�����������Դ���̹߳���
public class Share implements Runnable{
	private int num=100;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(num!=0) {
//				��õ�ǰ�̺߳���������
				System.out.println(Thread.currentThread().getName()+num--);
			}
		}
	public static void main(String[] args) {
		Share s=new Share();
		new Thread(s,"С��").start();
		new Thread(s,"С��").start();
		new Thread(s,"С��").start();
	}
}
