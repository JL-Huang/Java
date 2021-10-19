package ConcurrencyTest;
//synchronized(obj) {},obj称为同步监视器，可以是任何对象，一般是共享资源
//同步方法中无需指定同步监视器，因为它的同步监视器是this即调用方法的对象本身，或class类的模子
//同步监视器执行过程：
//	1.第一个线程访问，锁定同步监视器，执行块中的内容
//	2.第二个线程访问发现被锁定，无法访问
//	3.第一个线程访问完毕，解锁
//	4.第二个线程进去访问
public class SynchronizedObj {
	public static void main(String[] args) {
	SynAccount account=new SynAccount("m ",1000);
	new Thread(new Bank(500, 2200, "f", account)).start();
	new Thread(new Bank(500, 200, "m", account)).start();
}
}
class SynAccount{
	String name;
	int money;
	public SynAccount(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	
}
class Bank implements Runnable{
	int input;
	int output;
	String name;
	SynAccount synAccount;
	


	public Bank(int input, int output, String name, SynAccount synAccount) {
		super();
		this.input = input;
		this.output = output;
		this.name = name;
		this.synAccount = synAccount;
	}



	@Override
	public void run() { 
//		锁住对象，在块里执行要运行的代码
//		之前的出错之处在于，t1执行到现余额时，t2已经执行到取出余额，这样子t1显示的就是t2执行完后的余额
//		锁住余额后，每次改变只能由一个线程执行
//		但是这里会造成低效率，synAccount被锁住，则另一个线程加入仅仅是读也还要等前一个线程执行完，效率低
//		所以可以把读的操作写在Synchronized之前
		if(synAccount.money<0) {
			return;
		}
		synchronized(synAccount) {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().getName()+"余额"+"--"+synAccount.money);
			synAccount.money+=input;
			synAccount.money-=output;
			System.out.println(Thread.currentThread().getName()+"--"+input);
			System.out.println(Thread.currentThread().getName()+"--"+output);
			System.out.println(Thread.currentThread().getName()+"现余额"+"--"+synAccount.money);
			
		}
	}
}
