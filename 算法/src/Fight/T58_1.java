package Fight;

import java.util.Scanner;

public class T58_1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int[][] map=new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int result=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1) {
					result++;
					clear(i, j, m, n, map);
				}
			}
		}
		System.out.println(result);
	}
	public static void clear(int row,int col,int m,int n,int[][] map) {
		if(row<0||row>=m||col<0||col>=n||map[row][col]!=1) return;
		map[row][col]=2;
		clear(row+1, col, m, n, map);
		clear(row, col+1, m, n, map);
		clear(row-1, col, m, n, map);
		clear(row, col-1, m, n, map);
	}
}
