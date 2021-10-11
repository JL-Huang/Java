package Fight;

import java.util.Scanner;

public class BeiKe4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		for(;n>0;n--) {
			String t=sc.nextLine();
			StringBuilder sb1=new StringBuilder();
			for(int i=0;i<t.length();i++) {
				if(t.charAt(i)=='1') sb1.append("63231323");
				if(t.charAt(i)=='2') sb1.append("53231323");
				if(t.charAt(i)=='3') sb1.append("43231323");
			}
			String s=sc.nextLine();
			StringBuilder sb2=new StringBuilder(s.substring(0,sb1.length()));
			int result=0;
			for(int i=0;i<=s.length()-sb1.length();i++) {
				if(sb2.toString().equals(sb1.toString())) {
					result++;
				}
				if(i==s.length()-sb1.length()) break;
				sb2.deleteCharAt(0);
				sb2.append(s.charAt(i+sb1.length()));
			}
		System.out.println(result);	
		}
	}
}
