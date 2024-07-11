package Base.Generic相关;

import java.util.ArrayList;
import java.util.List;

public class List基本 {
public static void main(String[] args) {
	TestList();
}
//List是Collection的子接口,故其具有父接口的所有方法
//List是有序，元素可重复的容器,查询效率高，增删效率低，线程不安全
public static void TestList(){
	List<String> list1=new ArrayList<String>();
	list1.add("aa");
	list1.add("bb");
	list1.add("cc");
	List<String> list2=new ArrayList<String>();
	list2.add("aa");
	list2.add("dd");
	list2.add("ee");
//	retain，保留，保留list1中所有list2有的成员,注意参数List内容并没有改变
	list1.retainAll(list2);
	System.out.println(list1);
	System.out.println(list2);
//	这是把list2全加给对象List，注意list2内容并没有改变
	list1.addAll(list2);
	System.out.println(list1);
	System.out.println(list2);
	list1.add(1, "dd");
	System.out.println(list1);
	System.out.println(list1.indexOf("dd"));
	System.out.println(list1.lastIndexOf("dd"));
	
}
}
