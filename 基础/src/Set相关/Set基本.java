package Set���;

import java.util.HashSet;
import java.util.Set;

//Set��Listһ���̳���Collection���ص������򣬲����ظ�������Ԫ��û��������ֻ�ܱ�����
//��Ԫ����equal�����жϵ�Ϊtrue�����ܼ��룬����nullҲֻ����һ��
//set�ĳ���ʵ������HashSet��TreeSet
//HashSet�ĵײ��㷨����HashMap�������ֵ����ΪHashMap��key��value��һ������
//key�ǲ����ظ��ģ�Ҳ������ģ����Կ���ʵ��Set������
public class Set���� {
	public static void main(String[] args) {
		Set<String> s=new HashSet<String>();
		s.add("one");
		s.add("two");
		System.out.println(s);
		s.add("one");
		System.out.println(s);
//		ע�⣬size()���ص���Set�ĳ��ȣ���ָԪ�صĸ���
		System.out.println(s.size());
	}
}
