package ConcurrencyTest;

//�������֮�����ڣ�t1ִ�е������ʱ��t2�Ѿ�ִ�е�ȡ����������t1��ʾ�ľ���t2ִ���������
public class SynchronizedAccount {
public static void main(String[] args) {
	Account1 account1=new Account1(1000, "�ɷ���˻�");
//	������ס�����������������ͬ���½�������������û��ʲô����
	Drawing1 d1=new Drawing1(account1, "���Ӳ���", 100, 1150);
	Drawing1 d2=new Drawing1(account1, "�ɷ����", 200, 1000);
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
//	����һ���ǳ����͵Ĵ����̵߳Ĳ���ȫ��������Դ����ͬ�߳�ͬʱ�޸����������ģ�����Ҫ��������Դ
//	��һ��������ס���������������Ķ������Ա�����ᱻ��ס��ÿ��ֻ����һ���̵߳���
//	��������Ȼ��ס��Darwing1������û����סAccount1�����Բ��ܽ������
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"�˻�ԭ���"+account.money);
		account.money+=input;
		account.money-=output;

		System.out.println(Thread.currentThread().getName()+"������"+input);
		System.out.println(Thread.currentThread().getName()+"ȡ�����"+output);
		System.out.println(Thread.currentThread().getName()+"�˻������"+account.money);
		
		
	}
}