package ConcurrencyTest;

import java.util.ArrayList;
import java.util.List;

public class BetterCinemaTest {
public static void main(String[] args) {
//	���������
	List<Integer> availablelist=new ArrayList<Integer>();
	for(int i=0;i<10;i++) {
		availablelist.add(i);
	}
	BetterCinema bc=new BetterCinema(availablelist, "����ӰԺ");
	List<Integer> needlist1=new ArrayList<Integer>();
	for(int i=0;i<3;i++) {
		needlist1.add(i);
	}
	List<Integer> needlist2=new ArrayList<Integer>();
	for(int i=5;i<7;i++) {
		needlist2.add(i);
	}
	new Thread(new BetterCustomer(bc, needlist1),"С��").start();
	new Thread(new BetterCustomer(bc, needlist2),"С��").start();
	
}
}
class BetterCinema{
	List<Integer> availablelist;
	String name;
	public BetterCinema(List<Integer> availablelist, String name) {
		super();
		this.availablelist = availablelist;
		this.name = name;
	}


	
}
class BetterCustomer implements Runnable{
	BetterCinema bc;
	List<Integer> needlist;
	
	public BetterCustomer(BetterCinema bc, List<Integer> needlist) {
		super();
		this.bc = bc;
		this.needlist = needlist;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (bc) {
			System.out.println("����λ��"+bc.availablelist);
			List<Integer> copylist=new ArrayList<Integer>(bc.availablelist);
//			ע����������д���Ǵ���ģ��������ǰ�availalist�ĵ�ַ����copylist����copylist������ͬ�ڶ�ǰ�߲���
//			List<Integer> copylist=bc.availablelist;
	
			copylist.removeAll(needlist);
			if(bc.availablelist.size()-copylist.size()==needlist.size()) {
				bc.availablelist=copylist;
				System.out.println("��Ʊ�ɹ���λ��Ϊ->"+Thread.currentThread().getName()+needlist);
				System.out.println("ʣ��λ��"+bc.availablelist);
			}else {
				System.out.println("��Ʊʧ��");
			}
		}
}
}