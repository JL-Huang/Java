package ArrayTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//StringBuilder,�����ݵ��ַ���
public class p17 {
public static void main(String[] args) {
	StringBuffer sb=new StringBuffer();
//	append������׷��
	for(int i=0;i<26;i++) {
		sb.append((char)('a'+i));
	}
//	insert����������
	sb.insert(0,"��ĸ��");
//	setCharAt,�滻��ע��ֻ����char�����滻
	sb.setCharAt(25, '7');
//	delete��ɾ��
	sb.delete(2, 4);
	char[] a=new char[sb.length()];
	sb.getChars(0, sb.length(), a, 0);
	System.out.println(a[0]);
//	b=��StringBuilder����Ϊ�ַ���
//	String stre=sb.toString();
	System.out.println(sb);
	
	
	String str="";
	StringBuilder sb1=new StringBuilder("");
	long timestart1=System.currentTimeMillis();
	long ramstart1=Runtime.getRuntime().freeMemory();
	for(int i=0;i<500;i++) {
//		str=str+i;
//		���������������1000������,�ǳ��ķ��ڴ�
	}
//	��ȡ��ǰʣ���ڴ�
	long timeend1=System.currentTimeMillis();
	long ramend1=Runtime.getRuntime().freeMemory();
	System.out.println((timeend1-timestart1));
	System.out.println(ramstart1-ramend1);
	System.out.println(str);
	
	
	long timestart2=System.currentTimeMillis();
	long ramstart2=Runtime.getRuntime().freeMemory();
	for(int i=0;i<500;i++) {
//		sb1.append(i);
//		��ȷ������ֻ����һ������
	}
	long timeend2=System.currentTimeMillis();
	long ramend2=Runtime.getRuntime().freeMemory();
	System.out.println((timeend2-timestart2));
	System.out.println(ramstart2-ramend2);
	System.out.println(sb1);
}
}
