package 秋招;

import java.util.Scanner;

public class XinLang3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
        if(n<=0){
            System.out.println(0);
            return;
        }
        long[] result=new long[n+1];
		get_count(n, result);
		System.out.println(result[n]);
	}
	public static void get_count(int n,long[] result) {
		result[1]=1;
		if(n==1) return;
		result[2]=2;
		if(n==2) return;
		for(int i=3;i<=n;i++) {
			result[i]=result[i-1]+result[i-2];
		}
	}
}
