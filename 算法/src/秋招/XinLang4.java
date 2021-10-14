package «Ô’–;

import java.util.Scanner;

public class XinLang4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int m=sc.nextInt();
        if(N<=0||m<=0){
            System.out.println(0);
            return;
        }
        int[] result=new int[N+1];
        get_count(N, m, result);
        System.out.println(result[N]);
	}
	public static void get_count(int N,int m,int[] result) {
		for(int i=1;i<=m;i++) {
			if(i<=N) 
			result[i]=get_count(i);
			else return;
		}
		for(int i=m+1;i<N+1;i++) {
			for(int j=1;j<=m;j++) {
				result[i]+=result[i-j];
			}
		}
	}
	public static int get_count(int k) {
		if(k==1) return 1;
		return 2*get_count(k-1);
	}
}
