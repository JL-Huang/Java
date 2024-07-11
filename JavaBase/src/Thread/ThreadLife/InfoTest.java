package Thread.ThreadLife;
//这里展示一些线程常用的信息
public class InfoTest {
public static void main(String[] args) throws InterruptedException {
//	isAlive()静态方法,线程没有死亡都返回true
	System.out.println(Thread.currentThread().isAlive());
//	如下,注意区别代理类名字与线程名字
	Thread t=new Thread(new Info("代理类名字"));
//	setName()不是静态方法,需要一个thread对象才能调用
	t.setName("线程名字");
	t.start();
	Thread.sleep(1000);
//	一秒后，线程已经执行完，死亡了
	System.out.println(t.isAlive());
}
}
class Info implements Runnable{
	String name;
	@Override
	public void run() {
		// TODO Auto-generated method stub
	System.out.println(Thread.currentThread().getName()+"--"+name);
	}
	public Info(String name) {
		super();
		this.name = name;
	}
	
}
