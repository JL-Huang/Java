package ConcurrencyTest;

public class Unsafeticket {
	public static void main(String[] args) {
//		����д�������˶��ʵ���࣬���ж��ticketnum
//		Thread t1=new Thread(new test(),"a");
//		Thread t2=new Thread(new test(),"b");
//		t1.start();
//		t2.start();
		Test test1=new Test();
		Thread t1=new Thread(test1,"a");
		Thread t2=new Thread(test1,"b");
		t1.start();
		t2.start();
	}

}
class Test implements Runnable{
	private int ticketnum=100;
	private boolean flag=true;
	@Override
	public void run() {

//������for�Ǵ���ģ���Ϊi����for�ľֲ����������������̴߳���ticketnum��������i������
//		for(int i=0;i<100;i++) {

		while(flag==true) {
//			��ticketnumС�������ѭ�������ǿ��Կ�������ticketnum��һ���߳����Ѿ�Ϊ0�ˣ���һ���̻߳���ִ��
//			���һ������������̳߳���ͬһ�����ݵ�����������̲߳���ȫ
			
//			���ָ�����ԭ�����������ticket=1ʱֻ��a��b�����̣߳�˯����-1����Դ��Ϊ0ʱ���˻�û���룬�Ѿ�
//			���ܽ����ˣ��������a�߳�,a������Դ˯��50ms������a˯��ʱb�����ˣ�Ȼ��b˯����a�����ˣ�ticketnum-1
//			Ȼ��bҲ�����ˣ���ʱb���ŵ���Դ�Ѿ����0�������Ѿ������̣߳�ֻ�ܼ���ִ��ticketnum-1
			
//			������ͬ����ԭ��ÿ���̶߳����Լ������ռ䣬����Դ����������ġ�
//			�̵߳�����Դʱ���Ǹ���-�ı�-�������ݸ����������ӵķ�ʽ
//			������һ���̸߳ı������ݻ�û���ظ����棬��һ���߳�һ�����������ݸ������ˣ������Ӿͻ������ֵ
//			�����Ǳ�����Դ˯�����֣�����Ŵ����ʱ���
			if(ticketnum<=0) {
				flag=false;
			}		
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				System.out.println(Thread.currentThread().getName()+"--"+ticketnum--);

		}

//		}

	}
	
}