package Fight;

import java.util.Scanner;

public class MT5 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.valueOf(sc.nextLine());
		int[] a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
	}
}
