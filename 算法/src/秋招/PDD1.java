package 秋招;

import java.util.Scanner;

public class PDD1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		int[][] result=new int[n][n];
//		Arrays.fill(result, 0);
		for(int i=0;i<n/2-1;i++) {
			for(int j=i+1;j<n/2;j++) {
				result[i][j]=2;
			}
		}
		for(int i=0;i<n/2-1;i++) {
			for(int j=(n+1)/2;j<n-i-1;j++) {
				result[i][j]=1;
			}
		}
		for(int i=1;i<n/2;i++) {
			for(int j=n-1;j>n-i-1;j--) {
				result[i][j]=8;
			}
		}
		for(int i=(n+1)/2;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				result[i][j]=7;
			}
		}
		for(int i=n/2+1;i<n;i++) {
			for(int j=(n+1)/2;j<i;j++) {
				result[i][j]=6;
			}
		}
		for(int i=n/2+1;i<n;i++) {
			for(int j=n-i;j<n/2;j++) {
				result[i][j]=5;
			}
		}
		for(int i=(n+1)/2;i<n-1;i++) {
			for(int j=0;j<n-i-1;j++) {
				result[i][j]=4;
			}
		}
		for(int i=1;i<n/2;i++) {
			for(int j=0;j<i;j++) {
				result[i][j]=3;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
}
