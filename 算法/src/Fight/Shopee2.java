package Fight;

import java.util.Scanner;

public class Shopee2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] strs=sc.nextLine().split(" ");
		int N=Integer.parseInt(strs[0]);
		int M=Integer.parseInt(strs[1]);
		System.out.println((int)Math.pow(N+1, M));
		int a=1;
		for(int i=1;i<M;i++) {
			a*=(N+i);
		}
		a=a*(M-1)/2;
	}
}
