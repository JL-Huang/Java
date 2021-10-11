package ThreadLife;
//终止线程：
//1.正常执行完毕：次数
//2.外部干涉：加入标识
public class StopThread implements Runnable{
//	1.新建一个标志，为true线程运行
	private boolean flag=true;
	private String name;
	
	public StopThread(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		int i=0;
		// TODO Auto-generated method stub
//		2.关联标识
		while(flag) {
			System.out.println(i++);
		}
	}
//	3.定义改变标识的方法
	public void change() {
		this.flag=false;
	}
	public static void main(String[] args) {
	StopThread st=new StopThread("哈哈哈");
	new Thread(st).start();
	for(int i=0;i<100000;i++) {
		if(i==99000) {
//			非静态方法只有实例化了对象才能调用
			st.change();
		}
	}
	}
}
