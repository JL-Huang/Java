package «Ô’–;

import java.util.Scanner;

public class MT3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.valueOf(sc.nextLine());
		String[] a_str=sc.nextLine().split(" ");
		int[]a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=Integer.valueOf(a_str[i]);
		}
		int[] b=new int[n];
		for(int i=0;i<n;i++) {
			b[i]=a[i];
			for(int j=0;j<n;j++) {
				b[i]=b[i]^(i%(j+1));
			}
		}
		int result=b[0];
		for(int i=1;i<n;i++) {
			result=result^b[i];
		}
		System.out.println(result);
	}
}
