package Base.Set相关;

import java.util.HashSet;
import java.util.Set;

//Set与List一样继承自Collection，特点是无序，不可重复，而且元素没有索引，只能遍历查
//新元素若equal方法判断到为true，则不能加入，甚至null也只能有一个
//set的常用实现类有HashSet与TreeSet
//HashSet的底层算法就是HashMap，放入的值是作为HashMap的key，value是一个常量
//key是不能重复的，也是无序的，所以可以实现Set的特性
public class Set基本 {
	public static void main(String[] args) {
		Set<String> s=new HashSet<String>();
		s.add("one");
		s.add("two");
		System.out.println(s);
		s.add("one");
		System.out.println(s);
//		注意，size()返回的是Set的长度，是指元素的个数
		System.out.println(s.size());
	}
}
