package ThreadLife;
//����չʾһЩ�̳߳��õ���Ϣ
public class InfoTest {
public static void main(String[] args) throws InterruptedException {
//	isAlive()��̬����,�߳�û������������true
	System.out.println(Thread.currentThread().isAlive());
//	����,ע������������������߳�����
	Thread t=new Thread(new Info("����������"));
//	setName()���Ǿ�̬����,��Ҫһ��thread������ܵ���
	t.setName("�߳�����");
	t.start();
	Thread.sleep(1000);
//	һ����߳��Ѿ�ִ���꣬������
	System.out.println(t.isAlive());
}
}
class Info implements Runnable{
	String name;
	@Override
	public void run() {
		// TODO Auto-generated method stub
	System.out.println(Thread.currentThread().getName()+"--"+name);
	}
	public Info(String name) {
		super();
		this.name = name;
	}
	
}