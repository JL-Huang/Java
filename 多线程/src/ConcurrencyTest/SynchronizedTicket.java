package ConcurrencyTest;


//synchronized:ͬ��������ͬ����
//�����߳��������������߳�����
//��ʽ���ڷ��������������ڳ�Ա������λ����
public class SynchronizedTicket {
public static void main(String[] args) {
	Test1 test1=new Test1();
//	����߳�ͬʱ����test1������Ҫ��סtest1����
	Thread t1=new Thread(test1,"a");
	Thread t2=new Thread(test1,"b");
	t1.start();
	t2.start();
	
}
}
class Test1 implements Runnable{
		
	boolean flag=true;
	int ticketnum=100;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag) {
			qiang();
		}
	}
//	����֮��ÿ�θ÷���ֻ�ܱ�һ���̵߳���
//	����������ǲ������0�ģ���Ϊ--�ź�������ʹ���ټ�
//	����Ա����ʵ��������this����ʹ�ø÷����Ķ������Դ��
	public synchronized void qiang()  {

//		int j=10;
		
		if(ticketnum<=0) {
			flag=false;
			return;
		}

		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(j+1);
		System.out.println(Thread.currentThread().getName()+"--"+ticketnum--);
		
	}
}
//Ҳ���������ַ�ʽ����this�����ǵ��õ�ǰ�����Ķ���
//ע�ⲻ����ticketnum����test�ĵ�ַ�ǲ���ģ����������Եĵ�ַ�Ǳ�ģ��������������ַ
//������ͬ����Ҫ���Է�Χ����Χ̫С�ˣ������ͷţ����ǻ�����̲߳���ȫ�������ˣ�����ɲ���Ҫ��Ч���½�
//���ķ�Χ��ʵ�����ݵķ�Χ����������ǰһ��if�ǿ���û��Ʊʱ����̷߳��ʣ�����ֱ�Ӳ��Ŷӵȴ�����������
//��һ��if�ǿ������һ��Ʊ���ü��������Ѿ�������ǰ�棬һ�����̿���������Ȼ��ʹticketnum=0
//��һ�����̿������ж�������﷢���Ѿ�����ȥ��
//public synchronized void qiang()  {
//	if(ticketnum<=0) {
//		flag=false;
//		return;
//	}
//	synchronized(this){
//if(ticketnum<=0) {
//flag=false;
//return;
//}
//		}
//	try {
//		Thread.sleep(2);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
////	System.out.println(j+1);
//	System.out.println(Thread.currentThread().getName()+"--"+ticketnum--);
//	
//}
//}