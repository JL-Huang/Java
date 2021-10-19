package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Collections是一个工具类，提供对List,Map,Set的增删改查方法
//注意Collections说对容器直接操作，会改变容器的值
public class Collections基本 {
public static void main(String[] args) {
	List<Integer> list=new ArrayList<Integer>();
	for(int i=0;i<10;i++) {
		list.add(i);
	}
	

	Collections.shuffle(list);	//随机排序
	System.out.println(list);
	Collections.reverse(list);;	//逆序
	System.out.println(list);
	Collections.sort(list);	//顺序
	System.out.println(list);
//	Collections.fill(list, 1);
//	System.out.println(list);	//填充重写
	System.out.println(Collections.binarySearch(list, 5));//对顺序或逆序的容器进行折半查找
}
}
//插播javabean，javabean就是一个类，一个javabean必须有所有成员变量set与get方法及空构造器
