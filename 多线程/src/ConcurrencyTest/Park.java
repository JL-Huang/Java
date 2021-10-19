package ConcurrencyTest;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Park {
public static void main(String[] args) {
	Thread t1=new Thread(()-> {syns();
		}
		,"t1");
	t1.start();
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("main");
	LockSupport.unpark(t1);
}
public static void syns() {
	System.out.println("哈哈哈");
//	park()方法会造成阻塞，但不占用cpu
	LockSupport.park();
	System.out.println("呵呵呵");
	ReentrantLock r=new ReentrantLock(true);
	r.lock();
}
}
