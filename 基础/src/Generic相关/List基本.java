package Generic���;

import java.util.ArrayList;
import java.util.List;

public class List���� {
public static void main(String[] args) {
	TestList();
}
//List��Collection���ӽӿ�,������и��ӿڵ����з���
//List������Ԫ�ؿ��ظ�������,��ѯЧ�ʸߣ���ɾЧ�ʵͣ��̲߳���ȫ
public static void TestList(){
	List<String> list1=new ArrayList<String>();
	list1.add("aa");
	list1.add("bb");
	list1.add("cc");
	List<String> list2=new ArrayList<String>();
	list2.add("aa");
	list2.add("dd");
	list2.add("ee");
//	retain������������list1������list2�еĳ�Ա,ע�����List���ݲ�û�иı�
	list1.retainAll(list2);
	System.out.println(list1);
	System.out.println(list2);
//	���ǰ�list2ȫ�Ӹ�����List��ע��list2���ݲ�û�иı�
	list1.addAll(list2);
	System.out.println(list1);
	System.out.println(list2);
	list1.add(1, "dd");
	System.out.println(list1);
	System.out.println(list1.indexOf("dd"));
	System.out.println(list1.lastIndexOf("dd"));
	
}
}