package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Collections��һ�������࣬�ṩ��List,Map,Set����ɾ�Ĳ鷽��
//ע��Collections˵������ֱ�Ӳ�������ı�������ֵ
public class Collections���� {
public static void main(String[] args) {
	List<Integer> list=new ArrayList<Integer>();
	for(int i=0;i<10;i++) {
		list.add(i);
	}
	

	Collections.shuffle(list);	//�������
	System.out.println(list);
	Collections.reverse(list);;	//����
	System.out.println(list);
	Collections.sort(list);	//˳��
	System.out.println(list);
//	Collections.fill(list, 1);
//	System.out.println(list);	//�����д
	System.out.println(Collections.binarySearch(list, 5));//��˳�����������������۰����
}
}
//�岥javabean��javabean����һ���࣬һ��javabean���������г�Ա����set��get�������չ�����
