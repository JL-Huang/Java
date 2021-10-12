package ConcurrencyTest;

import ThreadLife.SleepTest;

//�����ͬ��������ɻ��಻�ͷ���Դ�Ӷ�����ȴ�
//һ�㷢����ͬ���г��ж���������
public class DeadLock {
	public static void main(String[] args) {
		new Thread(new Trade("��",1)).start();
		new Thread(new Trade("��",2)).start();
	}
}
class Money{
	int num;

	public Money(int num) {
		super();
		this.num = num;
	}
	
}
class Item{
	int num;

	public Item(int num) {
		super();
		this.num = num;
	}
	
}
class Trade implements Runnable{
//	��̬��Ա���������������ʵ��������Ȼ����ʱ���ָ��
	 static Money money=new Money(100);
	 static Item item=new Item(10);
	 String trader;
	 int temp;
	 
	public Trade(String trader, int temp) {
		super();
		this.trader = trader;
		this.temp = temp;
	}
//�о��ֵֹģ���������˫�������Ѿ���������ˣ����ǲ�˫�������ǿ�����������
//	��������Ҫ�õ�����������ִ����ȥ�Ž������������õ������������ִ����ȥ
//	��������ܼ򵥣���Ƕ�׵���Ų��ȥ
//	�ܽ���ǲ�Ҫ��һ���������ͬʱ���ж��������
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(temp==1) {
			synchronized (money) {
				System.out.println("������Ǯ");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}synchronized (item) {
					
					System.out.println(++item.num);
				}
				
			}
		}else {
			synchronized (item) {
				System.out.println("�����Ż�");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}synchronized (money) {
					
					System.out.println(++money.num);
				}
			}
		}
	}
}