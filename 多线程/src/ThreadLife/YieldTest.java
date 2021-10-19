package ThreadLife;
//yield礼让,当前回到就绪状态而不是阻塞状态,就绪状态要想进入运行状态不需要手动运行,让操作系统调度
//注意是静态方法,没有对象,写在哪个线程中哪个线程就礼让
//礼让并不涉及阻塞,一个线程礼让了直接会回到就绪状态
public class YieldTest {
public static void main(String[] args) {
	MyYield my=new MyYield();
	new Thread(my,"a").start();
	new Thread(my,"b").start();
	
}
}
class MyYield implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		加了yield后,先执行到这一句线程的回到就绪状态,然后大概率在另一个线程执行了"开始"后第一个线程才执行"结束"
	System.out.println("开始"+Thread.currentThread().getName());
	Thread.yield();
	for(int i=0;i<10;i++) {
		System.out.println("结束"+Thread.currentThread().getName());
	}

	}
}
