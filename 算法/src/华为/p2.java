package ��Ϊ;

import java.util.Scanner;

//д��һ�����򣬽���һ������ĸ��������ɵ��ַ�������һ���ַ���Ȼ����������ַ����к��и��ַ��ĸ����������ִ�Сд��
public class p2 {
public static void main(String[] args) {
//	 Scanner sc=new Scanner(System.in);
////	 next�ӿ�ͷ��ո���з�������һ�����з���ո�Ȼ�����һ����β
//     String str = sc.next();
////     nextLine�ӿ�ͷ���β���з�������һ�����з����β
//     String br = sc.nextLine();
//     System.out.println(str);
//     System.out.println(br);
//}
//}


	Scanner sc=new Scanner(System.in);
		while(sc.hasNextLine()){
			String s=sc.nextLine();
			String d=sc.nextLine();
			//toUpperCaseת��д
			String s1=s.toUpperCase();
			String d1=d.toUpperCase();
//			Stringһ���ַ�תchar:charAt(int)
			char dd=d1.charAt(0);
			int i=0;
//		Stringתchar���飺toCharArrY();
			char[] ss=s1.toCharArray();
		for(char temp:ss){
			if(dd==temp){
				i++;
			}
		}
		System.out.println(i);
		}
		}
	}