package MyThread;

import java.util.Timer;
import java.util.TimerTask;

public class Timerr {
public static void main(String[] args) {
	Timer t=new Timer();
	TimeTest tt=new TimeTest();
//	1000ms后执行一次,注意执行后就不能再执行了
//	t.schedule(tt, 1000);
//	1000ms后每隔200执行一次
	t.schedule(tt, 1000,200);
	
}
}
//TimerTask:可以由timer调度定时执行的任务，写在run方法里面
class TimeTest extends TimerTask{
	@Override
	public void run() {
		// TODO Auto-generated method stub
	System.out.println("hhh");	
	}
}