package MyThread;
//方法一，一个类继承Thread类，thread类以已经实现了runnable接口，需要重写runnable中的run方法
public class Threadone extends Thread{
//	在run中执行要在线程里进行的操作
@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<2;i++) {
			System.out.println("一边听歌");	
		}

	}

public static void main(String[] args) {
//	每创建一个新线程，都需要新建一个上面的类，如果该类里有数据，则无法被共享
	Threadone t1=new Threadone();
//	结果是随机排列，具体是执行先main方法，新建了一个对象，开启线程，然后main方法继续执行，另一个线程也继续执行
	t1.start();
//	但是如果改成run方法，就只是普通方法的调用，就必须先听完歌再敲代码，没有开启线程
	t1.run();
	for(int i=0;i<2;i++) {
		System.out.println("一边敲代码");
	}

}
}
