package ThreadLife;
//线程默认是用户线程
//JVM必须等所有用户线程执行完才能停止
public class DaemonTest {
public static void main(String[] args) {
	Thread t=new Thread(new Alien());
//	要设为守护线程一定要在线程开始前设置
	t.setDaemon(true);
//	可以看到,Human运行到100,Alien马上停止运行
	t.start();
	new Thread(new Human()).start();
}
}
class Human implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			System.out.println("人类"+i);	
		}

	}
}
class Alien implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	for(int i=0;i<1000;i++) {
		System.out.println("外星人"+i);
	}
	}
}
