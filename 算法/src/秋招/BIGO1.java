package 秋招;

import java.util.Scanner;

public class BIGO1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int flag=1;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)!='\n'&&str.charAt(i)!='\t'&&str.charAt(i)!=' ') {
				sb.append(str.charAt(i));
			}
		}
		String str_new=sb.toString();
		int num=0;
		String num_str=null;
		for(int i=0;i<str_new.length();i++) {
			if(str_new.charAt(i)=='-') flag*=-1;
			else {
				num_str=str_new.substring(i,str_new.length());
				if(parse(num_str)==Integer.MIN_VALUE) System.out.println(Integer.MIN_VALUE);
				else System.out.println(flag*parse(num_str));
				return;
			}
		}
	}
	public static int parse(String input) {
		int result=0;
		for(int i=input.length()-1;i>=0;i--){
			if(!(input.charAt(i)>='0'&&input.charAt(i)<='9')) return Integer.MIN_VALUE;
			else result+=(input.charAt(i)-'0')*Math.pow(10, input.length()-1-i);
		}
		return result;
	}
}
