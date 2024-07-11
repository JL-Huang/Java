package Thread.MyThread;
//方法二实现线程资源共享
//要注意的是，开启线程与普通方法不同，runnable的实现类里面的资源被线程共享
public class Share implements Runnable{
	private int num=100;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(num!=0) {
//				获得当前线程和它的名字
				System.out.println(Thread.currentThread().getName()+num--);
			}
		}
	public static void main(String[] args) {
		Share s=new Share();
		new Thread(s,"小明").start();
		new Thread(s,"小黄").start();
		new Thread(s,"小红").start();
	}
}
