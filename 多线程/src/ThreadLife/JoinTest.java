package ThreadLife;
//join�ϲ��߳�,������join�����Ķ����߳�ִ�����,��ִ�������߳�,�ڶ����߳�ִ��ʱ�����߳�����
//join�ǳ�Ա����,��Ҫʵ��������
public class JoinTest {
//	��main��������ֱ���׳��쳣
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
//			�����ǽ������,��tִ����join��,���̱߳����tִ������ܼ���ִ��
			t.join();
		}
		System.out.println("main"+i);
	}
}
}
