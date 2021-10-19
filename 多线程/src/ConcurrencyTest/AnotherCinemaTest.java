package ConcurrencyTest;
//用同步方法的方式重写电影院
//前面的思路是把要共享的对象所在类做成锁，然后在真实类重写的run方法里加入同步块
//而这里的思路是把抢的过程做成锁，并且把run方法直接写在资源类中，方便引用资源类对象
//这样子有一个问题就是，前一种方法可以用把
public class AnotherCinemaTest {
public static void main(String[] args) {
	AnotherCinema ac=new AnotherCinema(10, "华工影院");
	new AnotherCustomer(ac, "小明", 5).start();
	new AnotherCustomer(ac, "小黄", 6).start();
//	new Thread(ac).start();
}
}
class AnotherCinema implements Runnable{
	
	int totalseat;
	String name;
	public AnotherCinema(int totalseat, String name) {
		super();
		this.totalseat = totalseat;
		this.name = name;
	}
	public synchronized boolean qiang(int seatneed) {
		System.out.println("可用位置"+totalseat);
		if(totalseat-seatneed>=0) {
			totalseat=totalseat-seatneed;
			return true;
		}else {
			return false;
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		这里是最难理解的地方，它的目的是要引用真实类对象的成员变量，同时还要做到每一个真实类对应其自身成员变量
//		采用了下面这种方法，把当前线程强转为真实类，这是一个互相调用的过程，run方法调用一个acer对象，这个对象
//		的构造方法里面一个参数是run接口，这个对象的成员变量seatneed被调用
		
//		思路是：启动线程后需要获得被共享的资源与当前线程的资源->把run方法写在共享资源类里面可以方便调用共享资源
//		->我还要要调用真实类的成员变量并且锁住共享资源->不要代理，直接用一个继承Thread的类开启线程，这个类再
//		调用共享资源的run方法->共享资源类的run方法应该要连接到继承类才能调用当前线程的属性->然后我把当前线程强转
//		为继承类，用一个继承类对象接收，就能用继承类的属性了->锁住资源类的调用方法，然后在run里调用该方法
		AnotherCustomer acer=(AnotherCustomer)Thread.currentThread();
//		if(totalseat-acer.seatneed>=0) {	这里就是并发抢票的过程，用一个方法来写
		boolean flag=qiang(acer.seatneed);
		if(flag)	{
			System.out.println("出票成功"+Thread.currentThread().getName()+acer.seatneed);
		}else {
			System.out.println("出票失败");
		}
	}
}	
class AnotherCustomer extends Thread{
	int seatneed;

	public AnotherCustomer(Runnable runnable,String name,int seatneed) {
//		调用父类构造方法:Thread(Runnable target, String name) 一个是接口实现类，一个是线程名字
//		这种构造方法可以不用写run方法，线程启动时直接用target类的run方法
		super(runnable,name);
		this.seatneed = seatneed;
	}
	
}
