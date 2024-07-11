package Thread.ConcurrencyTest;

//利用线程写一个实例，一般是操作的对象一个类，其一个方法实现操作内容
//	实现Runnable接口用一个类，这个类将操作类作为成员变量并锁住
//	开启线程放在主类的main方法
//开启线程时，要先实例化真实类对象
public class CinemaTest {
	public static void main(String[] args) {
//		把要调用的对象单独成类
		Cinema cinema=new Cinema(100, "华工影院");
		Customer customer1=new Customer(cinema, 5);
		Customer customer2=new Customer(cinema, 3);
//		这里感觉有点不适应，因为以前不同Thread的参数都是一样的，这里变成不一样了
		new Thread(customer1,"小红").start();
		new Thread(customer2,"小明").start();
	}

}
class Cinema{
	int availseat;
	String name;//电影院名称

	public Cinema(int availseat, String name) {
		super();
		this.availseat = availseat;
		this.name = name;
	}

	public boolean booktickets() {
		System.out.println("可用位置"+availseat);
		if(availseat>0) {
			System.out.println("出票成功");
			return true;
		}else {
			System.out.println("出票失败");
			return false;
		}
	}

}
class Customer implements Runnable{
	Cinema cinema;
	int seatneeded;//要订的位置数量
//	int name;//顾客名字,省略了，直接用进程名作为顾客名字
	
	public Customer(Cinema cinema, int seatneeded) {
		super();
		this.cinema = cinema;
		this.seatneeded = seatneeded;
	}

	@Override
	public void run() {
//		没加synchronized之前，有可能两个同时出票，然后都显示票数100
//		加了synchronized，一定要一个线程先抢完，另一线程才显示抢 完之后剩余票数
//		这里的cinema其实是形参，在调用时指向Customer构造时的Cinema参数
		synchronized (cinema) {

			
			// TODO Auto-generated method stub
			boolean flag=cinema.booktickets();
			cinema.availseat=cinema.availseat-seatneeded;
			if(flag) {
				System.out.println(Thread.currentThread().getName()+"买了"+seatneeded+"张票");
			}
			
		}
	}
	
}
