package 华为;

import java.util.Scanner;

//写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
public class p2 {
public static void main(String[] args) {
//	 Scanner sc=new Scanner(System.in);
////	 next从开头或空格或换行符读到下一个换行符或空格，然后产生一个结尾
//     String str = sc.next();
////     nextLine从开头或结尾或换行符读到下一个换行符或结尾
//     String br = sc.nextLine();
//     System.out.println(str);
//     System.out.println(br);
//}
//}


	Scanner sc=new Scanner(System.in);
		while(sc.hasNextLine()){
			String s=sc.nextLine();
			String d=sc.nextLine();
			//toUpperCase转大写
			String s1=s.toUpperCase();
			String d1=d.toUpperCase();
//			String一个字符转char:charAt(int)
			char dd=d1.charAt(0);
			int i=0;
//		String转char数组：toCharArrY();
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