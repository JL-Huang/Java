package ConcurrencyTest;
//��ͬ�������ķ�ʽ��д��ӰԺ
//ǰ���˼·�ǰ�Ҫ����Ķ�����������������Ȼ������ʵ����д��run���������ͬ����
//�������˼·�ǰ����Ĺ��������������Ұ�run����ֱ��д����Դ���У�����������Դ�����
//��������һ��������ǣ�ǰһ�ַ��������ð�
public class AnotherCinemaTest {
public static void main(String[] args) {
	AnotherCinema ac=new AnotherCinema(10, "����ӰԺ");
	new AnotherCustomer(ac, "С��", 5).start();
	new AnotherCustomer(ac, "С��", 6).start();
//	new Thread(ac).start();
}
}
class AnotherCinema implements Runnable{
	
	int totalseat;
	String name;
	public AnotherCinema(int totalseat, String name) {
		super();
		this.totalseat = totalseat;
		this.name = name;
	}
	public synchronized boolean qiang(int seatneed) {
		System.out.println("����λ��"+totalseat);
		if(totalseat-seatneed>=0) {
			totalseat=totalseat-seatneed;
			return true;
		}else {
			return false;
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		�������������ĵط�������Ŀ����Ҫ������ʵ�����ĳ�Ա������ͬʱ��Ҫ����ÿһ����ʵ���Ӧ�������Ա����
//		�������������ַ������ѵ�ǰ�߳�ǿתΪ��ʵ�࣬����һ��������õĹ��̣�run��������һ��acer�����������
//		�Ĺ��췽������һ��������run�ӿڣ��������ĳ�Ա����seatneed������
		
//		˼·�ǣ������̺߳���Ҫ��ñ��������Դ�뵱ǰ�̵߳���Դ->��run����д�ڹ�����Դ��������Է�����ù�����Դ
//		->�һ�ҪҪ������ʵ��ĳ�Ա����������ס������Դ->��Ҫ����ֱ����һ���̳�Thread���࿪���̣߳��������
//		���ù�����Դ��run����->������Դ���run����Ӧ��Ҫ���ӵ��̳�����ܵ��õ�ǰ�̵߳�����->Ȼ���Ұѵ�ǰ�߳�ǿת
//		Ϊ�̳��࣬��һ���̳��������գ������ü̳����������->��ס��Դ��ĵ��÷�����Ȼ����run����ø÷���
		AnotherCustomer acer=(AnotherCustomer)Thread.currentThread();
//		if(totalseat-acer.seatneed>=0) {	������ǲ�����Ʊ�Ĺ��̣���һ��������д
		boolean flag=qiang(acer.seatneed);
		if(flag)	{
			System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+acer.seatneed);
		}else {
			System.out.println("��Ʊʧ��");
		}
	}
}	
class AnotherCustomer extends Thread{
	int seatneed;

	public AnotherCustomer(Runnable runnable,String name,int seatneed) {
//		���ø��๹�췽��:Thread(Runnable target, String name) һ���ǽӿ�ʵ���࣬һ�����߳�����
//		���ֹ��췽�����Բ���дrun�������߳�����ʱֱ����target���run����
		super(runnable,name);
		this.seatneed = seatneed;
	}
	
}