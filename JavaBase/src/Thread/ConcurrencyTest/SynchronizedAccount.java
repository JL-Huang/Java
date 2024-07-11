package Thread.ConcurrencyTest;

//这里出错之处在于，t1执行到现余额时，t2已经执行到取出余额，这样子t1显示的就是t2执行完后的余额
public class SynchronizedAccount {
public static void main(String[] args) {
	Account1 account1=new Account1(1000, "丈夫的账户");
//	下面锁住的是这里，都是两个不同的新建对象，锁起来并没有什么意义
	Drawing1 d1=new Drawing1(account1, "妻子操作", 100, 1150);
	Drawing1 d2=new Drawing1(account1, "丈夫操作", 200, 1000);
	Thread t1=new Thread(d1);
	Thread t2=new Thread(d2);
	t1.start();
	t2.start();
	
}
}
 class Account1{
	int money;
	String name;
	public Account1(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}

	
}
class Drawing1 implements Runnable{
	Account1 account;
	String name;
	int input;
	int output;
	
	public Drawing1(Account1 account, String name, int input, int output) {
		this.name=name;	
		this.account = account;
		this.input = input;
		this.output = output;
	}
//	这是一个非常典型的错误，线程的不安全是由于资源被不同线程同时修改与访问引起的，所以要锁的是资源
//	把一个方法锁住，则调用这个方法的对象及其成员变量会被锁住，每次只能由一个线程调用
//	而这里虽然锁住了Darwing1，但是没有锁住Account1，所以不能解决问题
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"账户原余额"+account.money);
		account.money+=input;
		account.money-=output;

		System.out.println(Thread.currentThread().getName()+"存入金额"+input);
		System.out.println(Thread.currentThread().getName()+"取出余额"+output);
		System.out.println(Thread.currentThread().getName()+"账户现余额"+account.money);
		
		
	}
}
