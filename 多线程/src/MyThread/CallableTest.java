package MyThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//实现Callable接口，指定泛型，重写方法，方法注明返回值
public class CallableTest implements Callable<Boolean>{

	@Override
	public Boolean call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("一边唱歌");
		return true;
	}
public static void main(String[] args) throws InterruptedException, ExecutionException {
	CallableTest c1=new CallableTest();
//	创建执行服务
	ExecutorService ser=Executors.newFixedThreadPool(3);
//	提交执行,这一步会开启线程
	Future<Boolean>result1=ser.submit(c1);
//	获取返回的结果,就是上面的返回值
	boolean r1=result1.get();
	System.out.println(r1);
//	关闭服务
	ser.shutdownNow();
	System.out.println("一边写代码");
}
}
