package Generic���;

//Collectionr�����ӿ�
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Collectionr���� {
public static void main(String[] args) {
//	Collection��һ���ӿ�,��ʵ����ΪArrayList
	Collection<String> c=new ArrayList<String>();
	c.add("һ");
	c.add("��");
	System.out.println(c);
	System.out.println(c.size());
	System.out.println(c.isEmpty());
	Object[] objectlist=c.toArray();
	System.out.println(Arrays.toString(objectlist));
//	�Ƴ�������ɾ��,���ݶ�����,ֻ����c������ɾ���˶���ĵ�ַ
	c.remove("һ");
	System.out.println(c);
	System.out.println(c.contains("һ`"));
//	������ͬ��
	c.clear();
	System.out.println(c.isEmpty());
}
}
