package ConcurrencyTest;

//�������֮�����ڣ�t1ִ�е������ʱ��t2�Ѿ�ִ�е�ȡ����������t1��ʾ�ľ���t2ִ���������
public class UnsafeAccount {
public static void main(String[] args) {
	Account account=new Account(1000, "�ɷ���˻�");
	Drawing d1=new Drawing(account, "���Ӳ���", 100, 1150);
	Drawing d2=new Drawing(account, "�ɷ����", 200, 1000);
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
		System.out.println(Thread.currentThread().getName()+"�˻�ԭ���"+account.money);
		account.money+=input;
		account.money-=output;

		System.out.println(Thread.currentThread().getName()+"������"+input);
		System.out.println(Thread.currentThread().getName()+"ȡ�����"+output);
		System.out.println(Thread.currentThread().getName()+"�˻������"+account.money);
		
		
	}
}