package MyThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//ʵ��Callable�ӿڣ�ָ�����ͣ���д����������ע������ֵ
public class CallableTest implements Callable<Boolean>{

	@Override
	public Boolean call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("һ�߳���");
		return true;
	}
public static void main(String[] args) throws InterruptedException, ExecutionException {
	CallableTest c1=new CallableTest();
//	����ִ�з���
	ExecutorService ser=Executors.newFixedThreadPool(3);
//	�ύִ��,��һ���Ὺ���߳�
	Future<Boolean>result1=ser.submit(c1);
//	��ȡ���صĽ��,��������ķ���ֵ
	boolean r1=result1.get();
	System.out.println(r1);
//	�رշ���
	ser.shutdownNow();
	System.out.println("һ��д����");
}
}
