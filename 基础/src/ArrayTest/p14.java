package ArrayTest;

import java.util.Arrays;

public class p14 {
public static void main(String[] args) {
	String s1="dadawd dawdaf fc f f ";
	String s2=s1.replace(' ', '&');
	System.out.println(s2);
	//indexof,返回第一次出现需要查找的字符的索引
	System.out.println(s1.indexOf("wd"));
	String[] s3= {"aa","bb","cc","dd","ee","ff"};
	String[] s4=new String[6];
//	将S3复制到s4，从s3下标为1的开始，复制到s4下标为0的，共复制3个
//	可以封装成删除数组中某一个元素的方法（s3,index+1,s3,index,s3.length-index-1)
	System.arraycopy(s3, 1, s4, 0, 3);
	for(String n:s4) {
		System.out.println(n);
	}
	int[] s5= {1,2,3};
	System.out.println(s5);
//	Arrays.toString()是一个静态方法，是用来帮助打印数组的
	System.out.println(Arrays.toString(s5));
//	Arrays.binarySearch(a, key) Arrays提供的查找数组内容方法
//	返回该元素的索引，如果数组中没有该元素会报错
	System.out.println(Arrays.binarySearch(s5, 3));
	
	int[][] i1=new int[3][];
	i1[0]= new int[]{1,1,1,1};
	i1[1]=new int[] {2,2,2};
	i1[2]=new int[] {3,3,3};
	System.out.println(Arrays.deepToString(i1));
	for(int[] temp:i1) {
		System.out.println(Arrays.toString(temp));
	}
}
}
