package MyThread;
//������������ģʽ֮�̷ܳ�
public class PC1 {
public static void main(String[] args) {
	Container container=new Container(100);
	new Thread(new Consumer(container)).start();
	new Thread(new Productor(container)).start();
}
}
class Consumer implements Runnable{
	Container container;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			Bread bread=container.get();
			System.out.println("�ó��˵�"+bread.id+"�����,�ֿ⻹��"+container.count+"�����");
		}
		
	}
	public Consumer(Container container) {
		super();
		this.container = container;
	}
	
}
class Productor implements Runnable{
	Container container;
	Bread bread;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			bread=new Bread(i);
			container.put(bread);
			System.out.println("�����˵�"+bread.id+"�����,�ֿ⻹��"+container.count+"�����");
		}
	}
	public Productor(Container container) {
		super();
		this.container = container;
	}
	
}
class Container{
	int size;
	Bread[]breads;
	int count=0;
public Container(int size) {
		super();
		this.size = size;
//Ҫע�⣬breads��ʵ����Ҫ���ڹ��췽������ܷ��ڳ�Ա��������Ϊ��Ա������ʼ����ִ�й��췽��֮ǰ���Ѿ�ִ��
		this.breads=new Bread[size];
	}
//	�����
//	����������Ϊ��ֹ���ִ�ȡͬʱ��count�������³�����Դ����
	public synchronized void put(Bread bread) {
	if(this.count==size) {
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	breads[count]=bread;
	count++;	
	this.notify();
	}
//	ȡ����
	public synchronized Bread get() {
//		�������ˣ����ȡ��̫�죬����Ѿ����˻���ȡ����Ȼ�ᱨ��
//		����Ҫ����wait
//		wait���û�л��ѣ���ǰ�̻߳�һֱ������ȥ
		if(count==0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//			notify�Ǹ����߳����ȼ��������һ���߳�
			this.notify();
		count--;
		return breads[count];
	}
	
}
class Bread{
	int id;

	public Bread(int id) {
		super();
		this.id = id;
	}

	public Bread() {
		super();
		// TODO Auto-generated constructor stub
	}

}