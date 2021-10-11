package ConcurrencyTest;

//这里出错之处在于，t1执行到现余额时，t2已经执行到取出余额，这样子t1显示的就是t2执行完后的余额
public class UnsafeAccount {
public static void main(String[] args) {
	Account account=new Account(1000, "丈夫的账户");
	Drawing d1=new Drawing(account, "妻子操作", 100, 1150);
	Drawing d2=new Drawing(account, "丈夫操作", 200, 1000);
	Thread t1=new Thread(d1);
	Thread t2=new Thread(d2);
	t1.start();
	t2.start();
	
}
}
class Account{
	int money;
	String name;
	public Account(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}

	
}
class Drawing implements Runnable{
	Account account;
	String name;
	int input;
	int output;
	
	public Drawing(Account account, String name, int input, int output) {
		this.name=name;	
		this.account = account;
		this.input = input;
		this.output = output;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"账户原余额"+account.money);
		account.money+=input;
		account.money-=output;

		System.out.println(Thread.currentThread().getName()+"存入金额"+input);
		System.out.println(Thread.currentThread().getName()+"取出余额"+output);
		System.out.println(Thread.currentThread().getName()+"账户现余额"+account.money);
		
		
	}
}