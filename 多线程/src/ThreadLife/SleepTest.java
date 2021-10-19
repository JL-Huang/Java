package ThreadLife;
//sleep抱着资源睡觉,进入阻塞状态
import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepTest {
public static void main(String[] args) throws InterruptedException {
	Date now=new Date(System.currentTimeMillis()+10000);
	long nowsec=now.getTime();
	while(true) {
		System.out.println(new SimpleDateFormat("mm:ss").format(now));		
		now=new Date(now.getTime()-1000);
		Thread.sleep(1000);
			if(nowsec-10000>now.getTime()) {
				break;
			}
	}
}
}
