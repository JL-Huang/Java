package Base;

public class p5 {
	public int i;
	public String s;
	public static String ss;
	//��̬��ʼ���飬���ھ�̬�����ĳ�ʼ�������ܵ��÷Ǿ�̬�����뷽���������Ե��þ�̬����
	//�����5��˵�����ȼ����࣬�����ž�̬�����ĳ�ʼ����Ȼ����ִ�й��췽��
	static {
		ss="5";
		hhh();
	}
	//���췽����ͬ��һ��ķ��������о�̬�����Կ��Ա���̬�������ã����зǾ�̬���Կ����ڹ��췽���ڲ���this�ؼ���
	public p5(int i,String s,String ss) {
		this.i=i;
		this.s=s;
		this.ss=ss;
	}
	public static void main(String[] args) {
		p5 p=new p5(1,"2","3");
		p5.hhh();//���Ϊ3��˵���ڵ��ù��췽����ı侲̬������p5���о�̬����ss��ֵ�Ѿ����ı�
		p5.ss="4";//���￴������̬�����ĸ�ֵ��ͨ����+��̬�����ķ���
		hhh();//���Ϊ4��˵����̬�������þ�̬����
	}
	public static void hhh(){
		System.out.println(ss);
	}
}
