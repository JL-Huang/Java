package ConcurrencyTest;

import ThreadLife.SleepTest;

//过多的同步可能造成互相不释放资源从而互相等待
//一般发生于同步中持有多个对象的锁
public class DeadLock {
	public static void main(String[] args) {
		new Thread(new Trade("赵",1)).start();
		new Thread(new Trade("李",2)).start();
	}
}
class Money{
	int num;

	public Money(int num) {
		super();
		this.num = num;
	}
	
}
class Item{
	int num;

	public Item(int num) {
		super();
		this.num = num;
	}
	
}
class Trade implements Runnable{
//	静态成员变量必须在类里就实例化，不然调用时会空指针
	 static Money money=new Money(100);
	 static Item item=new Item(10);
	 String trader;
	 int temp;
	 
	public Trade(String trader, int temp) {
		super();
		this.trader = trader;
		this.temp = temp;
	}
//感觉怪怪的，本来不用双重锁都已经造成死锁了，但是不双重锁还是可以正常运行
//	可能是需要拿到锁才能正常执行下去才叫死锁，不是拿到对象才能正常执行下去
//	解决方法很简单，把嵌套的锁挪出去
//	总结就是不要再一个代码块里同时持有多个对象锁
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(temp==1) {
			synchronized (money) {
				System.out.println("我拿着钱");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}synchronized (item) {
					
					System.out.println(++item.num);
				}
				
			}
		}else {
			synchronized (item) {
				System.out.println("我拿着货");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}synchronized (money) {
					
					System.out.println(++money.num);
				}
			}
		}
	}
}