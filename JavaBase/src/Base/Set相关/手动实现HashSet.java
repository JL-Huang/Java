package Base.Set相关;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//手动实现HashSet
public class 手动实现HashSet<E>{
	Map<E,String> map=new HashMap<>();
public static void main(String[] args) {
		手动实现HashSet<String> p=new 手动实现HashSet<>();
		p.add("hhh");
		p.add("jjj");
		p.add("kkk");
		System.out.println(p.size());
//		这里讲一下MAP的keyset()方法，返回的是一个Set对象
//		注意，它返回的不是拷贝而是引用，对返回的Set对象进行操作，会影响Map对象
		Set set=p.map.keySet();
		System.out.println(p);
		System.out.println(p.map);
		System.out.println(set);
		set.remove("hhh");
//		可以看到，这里是对set操作，但是却同时删除了map中的元素
		System.out.println(set);
		System.out.println(p.map);


}
public void add(E e) {
//	方法内部的局部变量只能有final一个修饰符
	final String s1="DEFAULT";
	map.put(e, s1);
}
//重写的toString方法只会对this.toString()生效，对其他不生效
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
