package MyThread;
//��̬����ģʽ
//������ʵ����ͬһ���ӿڣ���ʵ����Ϊ������ĳ�Ա������������Ĺ��췽�������������ʵ�࣬�ӿڷ�����дΪ��ʵ��Ľӿڷ���
//ִ��ʱֻ��Ҫִ�д�����Ľӿڷ���
//��ʵ���߳̿������������ӣ�Thread�Ǵ����࣬�Զ�����Ϊ��ʵ�ࡣrunΪ�ӿڷ���
//��װ��ģʽ���ƣ�����������ͬʱʵ�ֽӿڣ���װ��ģʽһ�����ǳ����࣬�����ǰѽӿڶ�������ǽӿ���ʵ�ֶ�����Ϊ��Ա����
public class StaticProxy {
public static void main(String[] args) {
	new He(new Me()).happymarry();
}
}

interface Marry{
	void happymarry();
}
class Me implements Marry{
	@Override
	public void happymarry() {
		// TODO Auto-generated method stub
		System.out.println("�ҽ��");
	}
}
class He implements Marry{
	private Marry taget;
	
	public He(Marry taget) {
		super();
		this.taget = taget;
	}

	@Override
	public void happymarry() {
		// TODO Auto-generated method stub
		this.taget.happymarry();
	}
}