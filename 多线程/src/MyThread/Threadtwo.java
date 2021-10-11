package MyThread;
//方法二：一个类实现runnable接口，重写run方法
public class Threadtwo implements Runnable{
//在run方法实现进程内容
	@Override
	public void run() {
		for(int i=0;i<2;i++) {
			System.out.println("一边听歌");
		}
		
	}
public static void main(String[] args) {
//	Threadone to=new Threadone();
////	Thread有一个是参数为Runnable实现类的构造方法
//	Thread t=new Thread(to);
//	t.start();
//	对于线程，可以直接不声明对象
	new Thread(new Threadone()).start();

	for(int i=0;i<20;i++) {
		System.out.println("一边敲代码");
	}
}
}
