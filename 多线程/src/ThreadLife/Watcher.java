package ThreadLife;

import java.lang.Thread.State;

public class Watcher {
public static void main(String[] args) throws InterruptedException {
	Thread t=new Thread(()-> {
		for(int i=0;i<5;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("������");
	});	
//	State��,���ڹ۲��߳�״̬,���ص�ǰ״̬
//	����new״̬
	State s=t.getState();
	System.out.println(s);
//	����runnable״̬
	t.start();
	s=t.getState();
	System.out.println(s);
//	�߳����к�,sleepʹ�߳̽���timed_waiting״̬
//	ע������,������,ͨ��State������һ���̻߳����һ���߳�״̬,Ȼ��ͨ���ж������
	while(s!=Thread.State.TERMINATED) {
//		������һ�ּ���̷߳���ͨ����ǰ�߳������ж�,����һ���߳�����,�߳��������1
//		int num=Thread.activeCount();
//		if(num==1) {
//			break;
//		}
		Thread.sleep(200);
		s=t.getState();
		System.out.println(s);
	}
	
}
}
