package Set���;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//�ֶ�ʵ��HashSet
public class �ֶ�ʵ��HashSet<E>{
	Map<E,String> map=new HashMap<>();
public static void main(String[] args) {
		�ֶ�ʵ��HashSet<String> p=new �ֶ�ʵ��HashSet<>();
		p.add("hhh");
		p.add("jjj");
		p.add("kkk");
		System.out.println(p.size());
//		���ｲһ��MAP��keyset()���������ص���һ��Set����
//		ע�⣬�����صĲ��ǿ����������ã��Է��ص�Set������в�������Ӱ��Map����
		Set set=p.map.keySet();
		System.out.println(p);
		System.out.println(p.map);
		System.out.println(set);
		set.remove("hhh");
//		���Կ����������Ƕ�set����������ȴͬʱɾ����map�е�Ԫ��
		System.out.println(set);
		System.out.println(p.map);


}
public void add(E e) {
//	�����ڲ��ľֲ�����ֻ����finalһ�����η�
	final String s1="DEFAULT";
	map.put(e, s1);
}
//��д��toString����ֻ���this.toString()��Ч������������Ч
@Override
public String toString() {
	StringBuilder sb=new StringBuilder();
	sb.append("[");
	for(Object temp:map.keySet()) {
		sb.append(temp+"|||||");
	}
	sb.setCharAt(sb.length()-1, ']');
	return sb.toString();
}

public int size() {
	return map.size();
}
}
