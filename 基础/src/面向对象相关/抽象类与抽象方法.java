package ����������;
public class ����������󷽷� {
public static void main(String[] args) {
//	������ľ�̬��Ա��������ֱ�ӱ���̬��������
	System.out.println(pp11.i);
}
}
//�г��󷽷�����ֻ�ܶ���Ϊ�����࣬���ܱ�ʵ����
//��������԰������ԣ��࣬���췽���������й��췽���������췽������ֱ����newʵ����
//������ֻ�ܱ��̳У����ұ���ʵ�ֳ��󷽷�
abstract class  pp11{
	private final static int k=10;
	void qq() {
		System.out.println("������");
	}
    abstract void pp();
	abstract void rr();
	static int i=1;
	public pp11() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
class sp11 extends pp11{
	@Override
	void rr() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void pp() {
		// TODO Auto-generated method stub
		System.out.println("hhh");
	}
	public  sp11() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}