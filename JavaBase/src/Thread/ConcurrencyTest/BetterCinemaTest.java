package Thread.ConcurrencyTest;

import java.util.ArrayList;
import java.util.List;

public class BetterCinemaTest {
public static void main(String[] args) {
//	容器的添加
	List<Integer> availablelist=new ArrayList<Integer>();
	for(int i=0;i<10;i++) {
		availablelist.add(i);
	}
	BetterCinema bc=new BetterCinema(availablelist, "华工影院");
	List<Integer> needlist1=new ArrayList<Integer>();
	for(int i=0;i<3;i++) {
		needlist1.add(i);
	}
	List<Integer> needlist2=new ArrayList<Integer>();
	for(int i=5;i<7;i++) {
		needlist2.add(i);
	}
	new Thread(new BetterCustomer(bc, needlist1),"小明").start();
	new Thread(new BetterCustomer(bc, needlist2),"小黄").start();
	
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
			System.out.println("可用位置"+bc.availablelist);
			List<Integer> copylist=new ArrayList<Integer>(bc.availablelist);
//			注意下面这种写法是错误的，这样子是把availalist的地址给了copylist，对copylist操作等同于对前者操作
//			List<Integer> copylist=bc.availablelist;
	
			copylist.removeAll(needlist);
			if(bc.availablelist.size()-copylist.size()==needlist.size()) {
				bc.availablelist=copylist;
				System.out.println("出票成功，位置为->"+Thread.currentThread().getName()+needlist);
				System.out.println("剩余位置"+bc.availablelist);
			}else {
				System.out.println("出票失败");
			}
		}
}
}
