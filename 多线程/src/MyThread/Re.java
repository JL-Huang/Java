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
	// ���޴�ӡ��˵��������ǰ�߳�����
	new Re().test();
}
}
