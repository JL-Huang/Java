package ArrayTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//StringBuilder,可扩容的字符串
public class p17 {
public static void main(String[] args) {
	StringBuffer sb=new StringBuffer();
//	append方法，追加
	for(int i=0;i<26;i++) {
		sb.append((char)('a'+i));
	}
//	insert方法，插入
	sb.insert(0,"字母表");
//	setCharAt,替换，注意只能用char类型替换
	sb.setCharAt(25, '7');
//	delete，删除
	sb.delete(2, 4);
	char[] a=new char[sb.length()];
	sb.getChars(0, sb.length(), a, 0);
	System.out.println(a[0]);
//	b=把StringBuilder返回为字符串
//	String stre=sb.toString();
	System.out.println(sb);
	
	
	String str="";
	StringBuilder sb1=new StringBuilder("");
	long timestart1=System.currentTimeMillis();
	long ramstart1=Runtime.getRuntime().freeMemory();
	for(int i=0;i<500;i++) {
//		str=str+i;
//		错误做法，会产生1000个对象,非常耗费内存
	}
//	获取当前剩余内存
	long timeend1=System.currentTimeMillis();
	long ramend1=Runtime.getRuntime().freeMemory();
	System.out.println((timeend1-timestart1));
	System.out.println(ramstart1-ramend1);
	System.out.println(str);
	
	
	long timestart2=System.currentTimeMillis();
	long ramstart2=Runtime.getRuntime().freeMemory();
	for(int i=0;i<500;i++) {
//		sb1.append(i);
//		正确做法，只产生一个对象
	}
	long timeend2=System.currentTimeMillis();
	long ramend2=Runtime.getRuntime().freeMemory();
	System.out.println((timeend2-timestart2));
	System.out.println(ramstart2-ramend2);
	System.out.println(sb1);
}
}
