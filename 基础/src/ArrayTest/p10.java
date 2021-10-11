package ArrayTest;

import java.util.Arrays;

//数组
public class p10 {
public static void main(String[] args) {
//	静态初始化
	 pp10[] p= {new pp10(1,"one"),new pp10(2,"two")};
//	 打印数组第一种方法，for循环
	for(int i=0;i<p.length;i++) {
		System.out.println(p[i].name);
	}
//	默认初始化
	int[] i3=new int[3];
//	打印数组第二种方法，导入Array包
	System.out.println(Arrays.toString(i3));
//	动态初始化
	String[] str3=new String[3];
	str3[0]="zero";
	str3[1]="one";
	str3[2]="two";
//	打印数组第三种方法foreach，只能读不能改
	for(String n:str3) {
		System.out.println(n);
	}
			
}
 static class pp10{
	int id;
	String name;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public pp10(int id,String name) {
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
}
