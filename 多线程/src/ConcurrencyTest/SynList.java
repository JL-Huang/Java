package ConcurrencyTest;
//�岥һ����������CopyOnWriteArrayList�����ڲ��Ѿ�ʵ�����̰߳�ȫ
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
//	���ﱾӦ�����9999����Ϊ������9999���̣߳�ÿһ���̶߳���list�������һ��Ԫ��
//	���û�У���Ϊlist�������߲�������һЩ�߳����ʧ��
//	�������synchronized��������
//	sleep��Ϊ�˷�ֹһЩ�߳��Ѿ�ִ����Ȼ���������
	Thread.sleep(100);
	System.out.println(list.size());

}
}
