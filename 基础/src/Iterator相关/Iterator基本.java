package Iterator���;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//Iterator��Collection�ĸ��࣬��һ���ӿڣ�����ʵ�������ı���
public class Iterator���� {
public static void main(String[] args) {
	System.out.println(testiteratorList());
	System.out.println(testiteratorSet());
}
public static StringBuilder testiteratorList() {
	List<String> list1=new ArrayList<String>();
	String str=null;
	StringBuilder sb=new StringBuilder();
	list1.add("one");
	list1.add("two");
	list1.add("three");
//	�����עһ�£�List��Collection�����࣬��Ȼʵ����Iterator�ӿ�
//	����iterator()��������һ�������͵�Iterator��
//	Iterator�������൱��forѭ����i��ֻʹ��һ�Σ�����ֱ�ӷ�for�����ʡ�ڴ�
//	Iterator<String> iterator1=list1.iterator();
//	hasNext()�����ǵ�������û�б�����ʱ����false�����򷵻�true
	for(Iterator<String> iterator1=list1.iterator();iterator1.hasNext();) {
//		Iterator�����toString���������Ƿ�������Ԫ�أ���next()�������Ƿ�����ʵ�����Ԫ��
		System.out.println(iterator1);
		str=iterator1.next();
		sb.append(str);
		System.out.println(str);
	}
	return sb;
}


//ͬ����Set����Ҳ��Collection�����࣬��ͬ��ʵ����Iterator�ӿ�
public static StringBuilder testiteratorSet() {
	Set<String> set=new HashSet<String>();
	set.add("hhh");
	set.add("jjj");
	set.add("kkk");
	StringBuilder sb=new StringBuilder();
	for(Iterator<String> iterator=set.iterator();iterator.hasNext();) {
//˳��˵һ�£������������������ڱ���ʱ�����ٶ���������add��remove��������Ϊ�������޷�ͬ����������̲߳���ȫ
		String str=iterator.next();
		sb.append(str);
		System.out.println(str);
	}
	return sb;
}
}
