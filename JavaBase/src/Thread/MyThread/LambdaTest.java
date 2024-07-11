package Thread.MyThread;
//Lambda用于简化代码，尤其是线程
public class LambdaTest {
//	这叫静态内部类
//public static void main(String[] args) {
//	new Thread(new MyThread()).start();
//}
//public static class MyThread implements Runnable{
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		System.out.println("一边听歌");
//	}
//	
//}
	
	
//	这叫成员内部类
//	public static void main(String[] args) {
//
////		成员变量成员类成员方法不能有除final外的修饰符
//		class MyThread1 implements Runnable{
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		System.out.println("一边听歌");
//	}
//			
//		}
//		//顺序执行，这句要放在类定义后面
//		new Thread(new MyThread1()).start();
//	}
	
//	Lambda表达式
//	将方法体内部直接在参数内部用固定格式标好，jdk8会自己推导这里实现的什么接口里面的什么方法
//	这样子做的话接口只能有一个方法
	public static void main(String[] args) {
//		推导结果是一个接口实现类，在该类内部推导出了接口的方法
//		推导时一定要让JDK知道，你想推导返回的是什么类
		new Thread(()->
		{System.out.println("一边听歌");}
		).start();
//接口方法的参数放括号里，甚至可以省略参数类型，只有一个参数甚至可以不要括号。只是一行代码甚至不要花括号和分号
//		如果有返回值而且只有一行代码，可以省略return
		J j=/*(int*/ a/*)*/->
//		{
			System.out.println("哈哈哈"+a)
//			;
//		}
		;
		j.jm(100);
	}
}

interface J{
	void jm(int a);
}

