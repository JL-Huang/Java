package ConcurrencyTest;
//synchronized(obj) {},obj��Ϊͬ�����������������κζ���һ���ǹ�����Դ
//ͬ������������ָ��ͬ������������Ϊ����ͬ����������this�����÷����Ķ�������class���ģ��
//ͬ��������ִ�й��̣�
//	1.��һ���̷߳��ʣ�����ͬ����������ִ�п��е�����
//	2.�ڶ����̷߳��ʷ��ֱ��������޷�����
//	3.��һ���̷߳�����ϣ�����
//	4.�ڶ����߳̽�ȥ����
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
//		��ס�����ڿ���ִ��Ҫ���еĴ���
//		֮ǰ�ĳ���֮�����ڣ�t1ִ�е������ʱ��t2�Ѿ�ִ�е�ȡ����������t1��ʾ�ľ���t2ִ���������
//		��ס����ÿ�θı�ֻ����һ���߳�ִ��
//		�����������ɵ�Ч�ʣ�synAccount����ס������һ���̼߳�������Ƕ�Ҳ��Ҫ��ǰһ���߳�ִ���꣬Ч�ʵ�
//		���Կ��԰Ѷ��Ĳ���д��Synchronized֮ǰ
		if(synAccount.money<0) {
			return;
		}
		synchronized(synAccount) {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().getName()+"���"+"--"+synAccount.money);
			synAccount.money+=input;
			synAccount.money-=output;
			System.out.println(Thread.currentThread().getName()+"--"+input);
			System.out.println(Thread.currentThread().getName()+"--"+output);
			System.out.println(Thread.currentThread().getName()+"�����"+"--"+synAccount.money);
			
		}
	}
}