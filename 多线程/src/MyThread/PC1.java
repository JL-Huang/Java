package MyThread;
//生产者消费者模式之管程法
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
			System.out.println("拿出了第"+bread.id+"个面包,仓库还有"+container.count+"个面包");
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
			System.out.println("存入了第"+bread.id+"个面包,仓库还有"+container.count+"个面包");
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
//要注意，breads的实例化要放在构造方法里，不能放在成员变量，因为成员变量初始化在执行构造方法之前就已经执行
		this.breads=new Bread[size];
	}
//	存操作
//	引入锁是因为防止出现存取同时对count操作导致出现资源抢夺
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
//	取操作
	public synchronized Bread get() {
//		问题来了，如果取的太快，库存已经空了还在取，必然会报错
//		所以要引入wait
//		wait如果没有唤醒，当前线程会一直阻塞下去
		if(count==0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//			notify是根据线程优先级随机唤醒一个线程
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
