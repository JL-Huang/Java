package ��Ϊ;

import java.util.Scanner;

//�����ַ������һ�����ʵĳ��ȣ������Կո������


//public class p1 {
//public static void main(String[] args) {
////	system.in,�س��������
//	Scanner sc=new Scanner(System.in);
////	�ж��Ƿ������룬�����ո���з���false
//	while(sc.hasNext()) {
//		String str=sc.next();
//		System.out.println(str);
//	}
////	�ж��Ƿ������룬�����ո���������˷���false
////	���Կ�����sc�ڲ���һ���α꣬ÿһ��ִ��next��nextline�α��ƶ��������ƶ�����·�������ַ���
//	while(sc.hasNextLine()) {
//		String strr=sc.nextLine();
//		System.out.println(strr);
//	}
//}
//}

public class p1{
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String s="";
    while(sc.hasNextLine()){
        s=sc.nextLine();
        System.out.println(s.length()-1-s.lastIndexOf(" "));
    }
}
}