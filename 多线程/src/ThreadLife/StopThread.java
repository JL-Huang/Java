package ThreadLife;
//��ֹ�̣߳�
//1.����ִ����ϣ�����
//2.�ⲿ���棺�����ʶ
public class StopThread implements Runnable{
//	1.�½�һ����־��Ϊtrue�߳�����
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
//		2.������ʶ
		while(flag) {
			System.out.println(i++);
		}
	}
//	3.����ı��ʶ�ķ���
	public void change() {
		this.flag=false;
	}
	public static void main(String[] args) {
	StopThread st=new StopThread("������");
	new Thread(st).start();
	for(int i=0;i<100000;i++) {
		if(i==99000) {
//			�Ǿ�̬����ֻ��ʵ�����˶�����ܵ���
			st.change();
		}
	}
	}
}
