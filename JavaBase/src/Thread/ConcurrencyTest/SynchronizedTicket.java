package Thread.ConcurrencyTest;


//synchronized:同步方法，同步块
//是在线程中锁，不是在线程外锁
//格式是在方法内锁，不能在成员变量的位置锁
public class SynchronizedTicket {
public static void main(String[] args) {
	Test1 test1=new Test1();
//	多个线程同时操作test1，所以要锁住test1对象
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
//	加锁之后，每次该方法只能被一个线程调用
//	正常情况下是不会输出0的，因为--放后面是先使用再减
//	锁成员方法实际锁的是this，即使用该方法的对象的资源，
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
//也可以用这种方式锁，this锁的是调用当前方法的对象
//注意不能锁ticketnum对象！test的地址是不变的，但是其属性的地址是变的，锁对象就是锁地址
//而且用同步块要锁对范围，范围太小了，过早释放，还是会造成线程不安全，锁大了，会造成不必要的效率下降
//锁的范围其实是数据的范围，比如这里前一个if是考虑没有票时多个线程访问，可以直接不排队等待解锁跳出，
//后一个if是考虑最后一张票，好几个进程已经来到锁前面，一个进程开锁，锁定然后使ticketnum=0
//下一个进程开锁，判断语句这里发现已经进不去了
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
