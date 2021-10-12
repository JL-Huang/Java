package ConcurrencyTest;

import java.util.ArrayList;
import java.util.List;

//�����߳�дһ��ʵ����һ���ǲ����Ķ���һ���࣬��һ������ʵ�ֲ�������
//	ʵ��Runnable�ӿ���һ���࣬����ཫ��������Ϊ��Ա��������ס
//	�����̷߳��������main����
//�����߳�ʱ��Ҫ��ʵ������ʵ�����
public class CinemaTest {
	public static void main(String[] args) {
//		��Ҫ���õĶ��󵥶�����
		Cinema cinema=new Cinema(100, "����ӰԺ");
		Customer customer1=new Customer(cinema, 5);
		Customer customer2=new Customer(cinema, 3);
//		����о��е㲻��Ӧ����Ϊ��ǰ��ͬThread�Ĳ�������һ���ģ������ɲ�һ����
		new Thread(customer1,"С��").start();
		new Thread(customer2,"С��").start();
	}

}
class Cinema{
	int availseat;
	String name;//��ӰԺ����

	public Cinema(int availseat, String name) {
		super();
		this.availseat = availseat;
		this.name = name;
	}

	public boolean booktickets() {
		System.out.println("����λ��"+availseat);
		if(availseat>0) {
			System.out.println("��Ʊ�ɹ�");
			return true;
		}else {
			System.out.println("��Ʊʧ��");
			return false;
		}
	}

}
class Customer implements Runnable{
	Cinema cinema;
	int seatneeded;//Ҫ����λ������
//	int name;//�˿�����,ʡ���ˣ�ֱ���ý�������Ϊ�˿�����
	
	public Customer(Cinema cinema, int seatneeded) {
		super();
		this.cinema = cinema;
		this.seatneeded = seatneeded;
	}

	@Override
	public void run() {
//		û��synchronized֮ǰ���п�������ͬʱ��Ʊ��Ȼ����ʾƱ��100
//		����synchronized��һ��Ҫһ���߳������꣬��һ�̲߳���ʾ�� ��֮��ʣ��Ʊ��
//		�����cinema��ʵ���βΣ��ڵ���ʱָ��Customer����ʱ��Cinema����
		synchronized (cinema) {

			
			// TODO Auto-generated method stub
			boolean flag=cinema.booktickets();
			cinema.availseat=cinema.availseat-seatneeded;
			if(flag) {
				System.out.println(Thread.currentThread().getName()+"����"+seatneeded+"��Ʊ");
			}
			
		}
	}
	
}