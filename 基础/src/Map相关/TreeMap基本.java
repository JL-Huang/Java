package Map���;

import java.util.Map;
import java.util.TreeMap;

//TreeMap�Ǻ�ڶ������ĵ���ʵ�֣���HashMapһ��Ҳ��Map��ʵ����
//���ĳ�Ա�����и��ڵ㣬��ڵ㣬�ҽڵ㣬���������Լ��ڵ���ɫ����Ҫ��һ�º������֪ʶ
//HashMapЧ�ʸ���TreeMap������Ҫ�����Map����Ҫ��TreeMap
//��Ҫ�Զ������������Ҫ�ż�һ����ʵ��Comparable�ӿڣ�����д�ķ����ﶨ����������ø��������Ϊkeyֵ
public class TreeMap���� {
public static void main(String[] args) {
	Map<Integer, String> treemap1=new TreeMap<Integer, String>();
	treemap1.put(3,"three");
	treemap1.put(9,"nine");
	treemap1.put(6,"six");
//	���Կ���TreeMap�ڴ��ʱ�ǰ����Ĵ�С˳�����е�
	for(Integer temp:treemap1.keySet()) {
		System.out.println(temp+"---"+treemap1.get(temp));
	}
	
	Map<Studentee,String> treemap2=new TreeMap<Studentee, String>();
	treemap2.put(new Studentee("��С��"), "����������");
	treemap2.put(new Studentee("����"), "����������");
	treemap2.put(new Studentee("��СС��"), "�����ĸ���");
	for(Studentee temp:treemap2.keySet()) {
		System.out.println(temp.name+"---"+treemap2.get(temp));
	}
}
}
//���Ƕ�����Ĳ��䣬�������ΪInteger���޷��Ƚ�Ȼ������ģ�
//��ʵ�ϣ��ڱȽ�ʱ�ǵ�����Comparable�ӿڣ���Ҫ�Զ���������Ҫʵ�ֱȽϽӿ�
class Studentee  implements Comparable<Studentee>{
	String name;
	
	public Studentee(String name) {
		super();
		this.name = name;
	}

	@Override
	public int compareTo(Studentee o) {
		if(this.name.length()>o.name.length()) {
			return 1;
		}else if(this.name.length()<o.name.length()) {
			return -1;
		}else {
			return 0;
		}

	}
	
}
