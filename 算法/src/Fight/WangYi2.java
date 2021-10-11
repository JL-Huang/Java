package Fight;

import java.util.Scanner;

public class WangYi2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int result=0;
		for(int i=0;i<str.length()-1;i++) {
			for(int j=i+2;j<str.length()+1;j++) {
				if(judge(str.substring(i,j))) result++;
			}
		}
		System.out.println(result);
	}
	public static boolean judge(String str) {
		for(int i=0;i<str.length()/2;i++) {
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) return false;
		}
		return true;
	}
}
