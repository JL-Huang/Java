package Base;

public class p8 {
	public static void main(String[] args) {
		son k=new son();
		//������Բ��ö���ֱ�ӵ��ù��췽������Ϊ���췽��û�з���ֵ
		//��ִ�й��췽����ʱ��Ҳִ���˸���Ĺ��췽��,��ʹ��ʡ����super();
		
	}
}
class father {
	//���췽�����Բ���д����ֵ����
	public  father(){
		System.out.println("father");
		
	}
}
class son extends father{
	int i;
	public son() {
		//super();
		System.out.println("son");
		this.i=1;
		
	}
}