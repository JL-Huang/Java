package ThreadLife;
//join合并线程,待调用join方法的对象线程执行完后,再执行其他线程,在对象线程执行时其他线程阻塞
//join是成员方法,需要实例化对象
public class JoinTest {
//	在main方法可以直接抛出异常
public static void main(String[] args) throws InterruptedException {
	Thread t=new Thread(()-> {
		for(int i=0;i<100;i++) {
			System.out.println("lamda"+i);
		}
	}
	);
	t.start();
	for(int i=0;i<100;i++) {
		if(i==20) {
//			本来是交替调度,对t执行了join后,主线程必须等t执行完才能继续执行
			t.join();
		}
		System.out.println("main"+i);
	}
}
}
