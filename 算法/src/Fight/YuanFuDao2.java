package Fight;

import java.util.Scanner;

public class YuanFuDao2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<N;i++) {
			String str=sc.nextLine();
			if(str.charAt(0)!='('&&str.charAt(str.length()-1)!=')') {
				System.out.println("invalid");
				continue;
			}
			else {
				char a=str.charAt(1);
				int m=0;
				int n=0;
				for(int j=2;j<str.length();j++) {
					if(str.charAt(j)>='0'&&str.charAt(j)<='9')
						m=str.charAt(j)-'0';
				}
				if(a=='*') {
					System.out.println(m*n);
					continue;
				}
				if(a=='+') {
					System.out.println(m+n);
					continue;
				}
				if(a=='-') {
					System.out.println(m-n);
					continue;
				}
				if(a=='/') {
					System.out.println(m/n);
					continue;
				}
				System.out.println("invalid");
			}
		}
	}
}
