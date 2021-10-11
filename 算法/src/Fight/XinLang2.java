package Fight;

import java.util.Scanner;

public class XinLang2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length();i++) {
			sb.append(str.charAt(str.length()-i-1));
		}
		System.out.println(sb.toString());
	}
}
