package Thread.MyThread;
//信号灯法：通过一个布尔变量加wait，控制生产者与消费者执行顺序
public class PC2 {
public static void main(String[] args) {
	TV tv=new TV();
	new Thread(new Actor(tv)).start();
	new Thread(new Audience(tv)).start();
}
}
class Actor implements Runnable{
	TV tv;
	
	public Actor(TV tv) {
		super();
		this.tv = tv;
	}

	public void run() {
		for(int i=0;i<20;i++) {
			if(i%2==0) {
				tv.show("hhh");
			}else {
				tv.show("jjj");
			}
		}
	}
}
class Audience implements Runnable{
	TV tv;
	
	public Audience(TV tv) {
		super();
		this.tv = tv;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			tv.watch();
		}
	}
}
class TV{
	String voice;
	boolean flag=true;
	public synchronized void show(String voice) {
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.voice=voice;
		System.out.println("表演了"+voice);
		this.notify();
		flag=!flag;
	}
	public synchronized void watch(){
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("听到了"+this.voice);
		this.notify();
		flag=!flag;
	}
}
