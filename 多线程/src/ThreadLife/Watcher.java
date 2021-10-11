package ThreadLife;

import java.lang.Thread.State;

public class Watcher {
public static void main(String[] args) throws InterruptedException {
	Thread t=new Thread(()-> {
		for(int i=0;i<5;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("哈哈哈");
	});	
//	State类,用于观察线程状态,返回当前状态
//	进入new状态
	State s=t.getState();
	System.out.println(s);
//	进入runnable状态
	t.start();
	s=t.getState();
	System.out.println(s);
//	线程运行后,sleep使线程进入timed_waiting状态
//	注意这行,很有用,通过State对象在一个线程获得另一个线程状态,然后通过判断来监控
	while(s!=Thread.State.TERMINATED) {
//		还有另一种监控线程方法通过当前线程数来判断,当另一个线程死亡,线程数便减少1
//		int num=Thread.activeCount();
//		if(num==1) {
//			break;
//		}
		Thread.sleep(200);
		s=t.getState();
		System.out.println(s);
	}
	
}
}
