package 秋招;

import java.util.Scanner;

public class ZhongXing1 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=Integer.parseInt(sc.nextLine());
	String[] a_str=sc.nextLine().split(" ");
	int[] a=new int[a_str.length];
	for(int i=0;i<a.length;i++) a[i]=Integer.parseInt(a_str[i]);
	String[] b_str=sc.nextLine().split(" ");
	int[] b=new int[b_str.length];
	for(int i=0;i<a.length;i++) b[i]=Integer.parseInt(b_str[i]);
	int[] sum=new int[a.length+b.length];
	for(int i=0;i<sum.length;i++) {
		if(i<a.length) sum[i]=a[i];
		else sum[i]=b[i-a.length];
	}
	int result=0;
	outer:for(int i=a.length;i<sum.length;i++) {
		if(sum[i]>sum[a.length-1]) continue;
		else {
			for(int j=a.length-1;j>=0;j--) {
				if(sum[i]<sum[j]) result++;
				else continue outer;
			}
		}
	}
	System.out.println(result);
}
}
