package Thread.ConcurrencyTest;

import java.util.concurrent.locks.ReentrantLock;

public class Lock {
	static ReentrantLock r=new ReentrantLock(true);
	public static void main(String[] args) {
		Thread t1=new Thread(()->{
			sync();
		});
		Thread t2=new Thread(()->{
			sync();
		});
		t1.start();
		t2.start();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.interrupt();
}
public static void sync() {
	try {
		r.lock();
//		r.lockInterruptibly();
		System.out.println(Thread.currentThread().getName());
		Thread.sleep(5000);
		r.unlock();
		System.out.println(Thread.currentThread().getName());
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
