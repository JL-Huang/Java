package «Ô’–;

import java.util.Arrays;
import java.util.Scanner;

public class GuangLianDa1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int x=sc.nextInt();
		int[] h=new int[n];
		for(int i=0;i<n;i++) h[i]=sc.nextInt();
		Arrays.sort(h);
		outer:for(int i=0;i<m;i++) {
			h[0]+=x;
			for(int j=0;j<h.length-1;j++) {
				if(h[j]>h[j+1]) {
					int temp=h[j];
					h[j]=h[j+1];
					h[j+1]=temp;
				}else {
					continue outer;
				}
			}
		}
		System.out.println(h[0]);
	}
}
