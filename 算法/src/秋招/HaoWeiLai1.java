package 秋招;

import java.util.Scanner;

public class HaoWeiLai1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			long a=sc.nextLong();
			long b=sc.nextLong();
			long k=sc.nextLong();
			System.out.println((a-b)*(k/2)+(k%2==0?0:a));
		}
	}
}
