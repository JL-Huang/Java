package MyThread;

public class Race implements Runnable{
//	犯了一个错误，把step设成了成员变量，然后win无参，这是错误的。
//	开启两个线程时，成员变量是共享的，而step应该是两个线程自己的属性才对
	public String winner;
	
	@Override
	public void run() {
		for(int step=0;step<=1000;step++) {

//			这里还是有点问题，有时会出现一方已经赢了，另一方还往前跑一步，可能是并发问题
			if(Thread.currentThread().getName()=="兔子"&&step==10) {
//				线程的异常只能trycatch，不能throws
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+step);
//			这里的this居然可以省略，惊了，这明明是非静态方法啊
			boolean b=this.win(step);
			if(b==true) {
				break; 
			}

			}
		}
	public boolean win(int s) {
//		这里是很关键的，winner是共享的变量，不加这句的话会出现在一个进程内winner已经赋值
//		但在另一个进程仍在继续跑，然后出现两个冠军
		if(winner!=null) {
			return true;
		}else {
			if(s==1000) {
				winner=Thread.currentThread().getName();
				System.out.println(winner);
				return true;
			}
		}
		return false;
	}

public static void main(String[] args) {
	Race r=new Race();
	new Thread(r,"兔子").start();
	new Thread(r,"乌龟").start();
	
}
}
