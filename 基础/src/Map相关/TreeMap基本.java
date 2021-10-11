package Map相关;

import java.util.Map;
import java.util.TreeMap;

//TreeMap是红黑二叉树的典型实现，与HashMap一样也是Map的实现类
//它的成员变量有父节点，左节点，右节点，本身数据以及节点颜色，需要补一下红黑树的知识
//HashMap效率高于TreeMap，在需要排序的Map才需要用TreeMap
//若要自定义排序规则，则要信件一个类实现Comparable接口，在重写的方法里定义排序规则，用该类对象作为key值
public class TreeMap基本 {
public static void main(String[] args) {
	Map<Integer, String> treemap1=new TreeMap<Integer, String>();
	treemap1.put(3,"three");
	treemap1.put(9,"nine");
	treemap1.put(6,"six");
//	可以看到TreeMap在存放时是按键的大小顺序排列的
	for(Integer temp:treemap1.keySet()) {
		System.out.println(temp+"---"+treemap1.get(temp));
	}
	
	Map<Studentee,String> treemap2=new TreeMap<Studentee, String>();
	treemap2.put(new Studentee("王小明"), "名字三个字");
	treemap2.put(new Studentee("王明"), "名字两个字");
	treemap2.put(new Studentee("王小小明"), "名字四个字");
	for(Studentee temp:treemap2.keySet()) {
		System.out.println(temp.name+"---"+treemap2.get(temp));
	}
}
}
//这是对上面的补充，如果键不为Integer是无法比较然后排序的，
//事实上，在比较时是调用了Comparable接口，若要自定义排序则要实现比较接口
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
