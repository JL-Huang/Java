package ThreadLife;
//���ȼ���1-10����
//���ȼ�Խ��,Խ������ִ��,����һ��
//NORM_PRIORITY:5
//MIN_PRIORITY:1
//MAX_PRIORITY:10
public class PriorityTest {
public static void main(String[] args) {
	Thread t1=new Thread(new Test1(),"a");
	Thread t2=new Thread(new Test1(),"b");
	Thread t3=new Thread(new Test1(),"c");
//	�������ȼ�һ��Ҫ������ǰ
	t1.setPriority(Thread.MAX_PRIORITY);
	t1.start();
	t2.start();
}
}
class Test1 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	System.out.println(Thread.currentThread().getName()+"--"+Thread.currentThread().getPriority());	
	}
}