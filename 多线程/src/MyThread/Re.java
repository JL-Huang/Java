package MyThread;

public class Re {
public void test() {
	boolean flag=true;
	synchronized (this) {
//		while(flag==true) {
//			synchronized (this) {
//			System.out.println("ReentrantLock");
//			}
//		}
	}
}
public static void main(String[] args) {
	// 无限打印，说明锁被当前线程重入
	new Re().test();
}
}
