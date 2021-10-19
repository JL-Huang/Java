package ConcurrencyTest;

public class Unsafeticket {
	public static void main(String[] args) {
//		这种写法创建了多个实现类，会有多个ticketnum
//		Thread t1=new Thread(new test(),"a");
//		Thread t2=new Thread(new test(),"b");
//		t1.start();
//		t2.start();
		Test test1=new Test();
		Thread t1=new Thread(test1,"a");
		Thread t2=new Thread(test1,"b");
		t1.start();
		t2.start();
	}

}
class Test implements Runnable{
	private int ticketnum=100;
	private boolean flag=true;
	@Override
	public void run() {

//这样用for是错误的，因为i属于for的局部变量，开启两个线程代理，ticketnum共享，但是i不共享
//		for(int i=0;i<100;i++) {

		while(flag==true) {
//			当ticketnum小于零结束循环，但是可以看到，当ticketnum在一个线程中已经为0了，另一个线程还在执行
//			并且还出现了两个线程出现同一个数据的情况，都叫线程不安全
			
//			出现负数的原因：正常情况在ticket=1时只有a或b进入线程，睡觉，-1，资源变为0时别人还没进入，已经
//			不能进入了，但是如果a线程,a抱着资源睡觉50ms，就在a睡觉时b进来了，然后b睡觉，a醒来了，ticketnum-1
//			然后b也醒来了，此时b抱着的资源已经变成0，但它已经进入线程，只能继续执行ticketnum-1
			
//			出现相同数的原因：每个线程都有自己工作空间，而资源是属于主存的。
//			线程调用资源时，是复制-改变-返回数据给主存这样子的方式
//			当出现一个线程改变了数据还没返回给主存，另一个线程一个把主存数据复制走了，这样子就会出现重值
//			尤其是抱着资源睡觉这种，会更放大这个时间差
			if(ticketnum<=0) {
				flag=false;
			}		
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				System.out.println(Thread.currentThread().getName()+"--"+ticketnum--);

		}

//		}

	}
	
}
