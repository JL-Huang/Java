package Generic���;
//����
public class ���� {
public static void main(String[] args) {
	Testnogeneric tng=new Testnogeneric();
//	����ǿת����,������ȻTestnogeneric�е�һ��������Object��,������ֱ�Ӹ��ַ���ֵ
	tng.set("eer", 0);
//	������Կ���,���ص���Object����,����ǿת���ܱ������String
	String str1=(String) tng.get(0);
	Testgeneric<String> tg=new Testgeneric();
	tg.set("����",1 );
	tg.get(1);
	System.out.println(tg.objectlist[1]);
//	����,��Ϊ�Ѿ������Ѿ�����tg.set������һ������ΪString
//	tg.set(123, 2);
}
}
class Testnogeneric{
	Object[] objlist=new Object[5];
	public void set(Object o,int index) {
		objlist[index]=o;
	}
	public Object get(int index) {
		return objlist[index];
	}
}
//���͵��β�һ��ΪTEV������ĸ,������֮��
class Testgeneric<E>{
	Object[] objectlist=new Object[5];
	public void set(E e,int index) {
		objectlist[index]=e;
	}
	@SuppressWarnings("unchecked")
	public E get(int index) {
//		����Ҳ����Ҫǿת��,���ǿ���������ǿת,����Ҫ����ʱ��ǿת
		return (E) objectlist[index];
	}
}