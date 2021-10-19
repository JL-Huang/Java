package Iterator相关;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//Iterator是Collection的父类，是一个接口，可以实现容器的遍历
public class Iterator基本 {
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
//	这里标注一下，List是Collection的子类，自然实现了Iterator接口
//	它的iterator()方法返回一个带泛型的Iterator类
//	Iterator的作用相当于for循环的i，只使用一次，所以直接放for里面节省内存
//	Iterator<String> iterator1=list1.iterator();
//	hasNext()方法是当容器有没有遍历完时返回false，否则返回true
	for(Iterator<String> iterator1=list1.iterator();iterator1.hasNext();) {
//		Iterator本身的toString方法并不是返回容器元素，其next()方法才是返回其实现类的元素
		System.out.println(iterator1);
		str=iterator1.next();
		sb.append(str);
		System.out.println(str);
	}
	return sb;
}


//同样，Set方法也是Collection的子类，其同样实现了Iterator接口
public static StringBuilder testiteratorSet() {
	Set<String> set=new HashSet<String>();
	set.add("hhh");
	set.add("jjj");
	set.add("kkk");
	StringBuilder sb=new StringBuilder();
	for(Iterator<String> iterator=set.iterator();iterator.hasNext();) {
//顺便说一下，迭代器创建出来后，在遍历时不能再对容器进行add或remove操作，因为迭代器无法同步，会出现线程不安全
		String str=iterator.next();
		sb.append(str);
		System.out.println(str);
	}
	return sb;
}
}
