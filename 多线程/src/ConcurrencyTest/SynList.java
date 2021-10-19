package ConcurrencyTest;
//插播一个并发容器CopyOnWriteArrayList，其内部已经实现了线程安全
import java.util.ArrayList;
import java.util.List;

public class SynList {
public static void main(String[] args) throws InterruptedException {
	List<String> list=new ArrayList<>();
	for(int i=0;i<10000;i++) {
		new Thread(()->{
			synchronized (list) {
				list.add(Thread.currentThread().getName());
				
			}
	}).start();
	}
//	这里本应该输出9999，因为开启了9999个线程，每一个线程都在list后面加了一个元素
//	最后并没有，因为list被共享，高并发导致一些线程添加失败
//	上面加了synchronized后问题解决
//	sleep是为了防止一些线程已经执行完然后来到输出
	Thread.sleep(100);
	System.out.println(list.size());

}
}
