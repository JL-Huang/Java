package Base;

public class p6 {
	int i;
	String s;
	public p6(int i,String s) {
		this.i=i;
		this.s=s;
	}
	public static void main(String[] args) {
		p6 p=new p6(1,"2");//�½���һ��p6����p
		p.h1(p);//��ʵ��p������h1�������β�p���Զ���pִ��h1����.��ʵ�������h1��Ϊ��̬�����ʣ�ֻ����ʾ��Ҫ
		System.out.println(p.s);
		//������Ϊ3��˵��h1����ȷʵ�ı��˶���p��ֵ
		p.h2(p);//��ʵ��p������h2�������β�p
		System.out.println(p.s);
		//������Ϊ3����h2��û�иı����p��ֵ
		//������Ϊ�����Ĵ����ǵ�ַ���ݣ��βε�ַ�õ���ʵ�ε�ַ��������βν��в��������ܽ������ɵ�ַ����ʵ��
		//��h2һ�����β�һ��ʼ�����ʵ�εĵ�ַ�����漴�βλ������һ�½�����ĵ�ַ����ʱ���ββ�������Ͳ��ܷ���ʵ����
	}
	public void h1(p6 p) {
		p.s="3";//����p����Ϊp6���β�
	}
	public void h2(p6 p) {
		p=new p6(4,"5");
	}
}
