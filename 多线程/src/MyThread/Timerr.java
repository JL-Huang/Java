package MyThread;

import java.util.Timer;
import java.util.TimerTask;

public class Timerr {
public static void main(String[] args) {
	Timer t=new Timer();
	TimeTest tt=new TimeTest();
//	1000ms��ִ��һ��,ע��ִ�к�Ͳ�����ִ����
//	t.schedule(tt, 1000);
//	1000ms��ÿ��200ִ��һ��
	t.schedule(tt, 1000,200);
	
}
}
//TimerTask:������timer���ȶ�ʱִ�е�����д��run��������
class TimeTest extends TimerTask{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	System.out.println("hhh");	
	}
}