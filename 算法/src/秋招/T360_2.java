package «Ô’–;

import java.util.Scanner;

public class T360_2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[] num=new int[m];
		int[] up_dowm=new int[m];
		for(int i=0;i<m;i++) {
			num[i]=sc.nextInt();
			up_dowm[i]=sc.nextInt();
		}
		boolean[] flag=new boolean[n+1];
		for(int i=0;i<m;i++) {
			flag[num[i]]=true;
		}
		for(int i=1;i<=n;i++) {
			if(!flag[i]) System.out.print(+i+" ");
		}
	}
}
