package 秋招;

import java.util.Scanner;

public class BeiKe2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		String str=sc.nextLine();
		int point=0;
		StringBuilder sb=new StringBuilder(str);
		for(int i=str.length()-1;i>=0;i--) {
			boolean flag=judge(sb.deleteCharAt(i).toString());
			if(flag) {
				point=(i+1)/2;
				break;
			}
		}
		System.out.println(point==0?n:n-point+1);
	}
	public static boolean judge(String a) {
		if(a.length()%2==1) return false;
		int half=a.length()/2;
		for(int i=0;i<half;i++) {
			if(a.charAt(i)!=a.charAt(i+half)) return false;
		}
		return true;
	}
}
