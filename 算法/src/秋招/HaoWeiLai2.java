package 秋招;

import java.util.Scanner;

public class HaoWeiLai2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		if(str.length()==1) {
			System.out.println(str.charAt(0)=='1'?1:0);
			return;
		}
		boolean flag=false;
		for(int i=1;i<str.length();i++) {
			if(str.charAt(i)=='1') flag=true;
		}
		System.out.println(!flag&&str.length()%2==1?(str.length()-1)/2:(str.length()-1)/2+1);
	}
}
