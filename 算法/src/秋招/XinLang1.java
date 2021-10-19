package 秋招;

import java.util.Scanner;

public class XinLang1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=Integer.toOctalString(Integer.parseInt(sc.nextLine()));
		int result=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='1') result++;
		}
		System.out.println(result);
	}
}
