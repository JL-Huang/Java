package 秋招;

import java.util.Scanner;

public class vivo1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int x0=sc.nextInt();
		int y0=sc.nextInt();
		int x1=sc.nextInt();
		int y1=sc.nextInt();
		sc.nextLine();
		char[][] a=new char[n][n];
		int[][] flag=new int[x1+1][y1+1];
		for(int i=0;i<n;i++) {
			String str=sc.nextLine();
			for(int j=0;j<n;j++) {
				a[i][j]=str.charAt(j);
			}
		}
		for(int i=2;i<x1+1;i++) {
			for(int j=2;j<y1+1;j++) {
				if(a[i-1][j-1]=='@'&&a[i-1][j-1]=='#') flag[i][j]=-1;
				else{
					if(a[i-2][j-1]=='@'||a[i-2][j-1]=='#') flag[i][j]=flag[i][j-1]+1;
					else if(a[i-1][j-2]=='@'||a[i-1][j-2]=='#') flag[i][j]=flag[i-1][j]+1;
					else flag[i][j]=Math.min(flag[i-1][j], flag[i][j-1])+1;
				}
			}
		}
		System.out.println(flag[x1][y1]-flag[x0][y0]);
	}
}
