package «Ô’–;

import java.util.Scanner;

public class JingDong2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0;i<T;i++) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			char[][] matrix=new char[n][m];
			boolean[][] flag=new boolean[n][m];
			sc.nextLine();
			for(int j=0;j<n;j++) {
				String strs=sc.nextLine();
				for(int k=0;k<m;k++) {
					matrix[j][k]=strs.charAt(k);
				}
			}
			int begin_x=0,begin_y=0,end_x=0,end_y=0;
			
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					if(matrix[j][k]=='S') {
						begin_x=j;
						begin_y=k;
					}
					if(matrix[j][k]=='E') {
						end_x=j;
						end_y=k;
					}
				}
			}
			System.out.println(findpath(begin_x, begin_y, end_x, end_y, matrix,flag)?"YES":"NO");
		}
	}
	public static boolean findpath(int begin_x,int begin_y,int end_x,int end_y,char[][] matrix,boolean[][] flag) {
		if(begin_x<0||begin_x>=matrix.length||begin_y<0||begin_y>=matrix[0].length||matrix[begin_x][begin_y]=='#'||flag[begin_x][begin_y])
			return false;
		if(begin_x==end_x&&begin_y==end_y) return true;
		flag[begin_x][begin_y]=true;
		boolean result=findpath(begin_x+1, begin_y, end_x, end_y, matrix,flag)||
				findpath(begin_x, begin_y+1, end_x, end_y, matrix,flag)||
				findpath(begin_x-1, begin_y, end_x, end_y, matrix,flag)||
				findpath(begin_x, begin_y-1, end_x, end_y, matrix,flag);
		flag[begin_x][begin_y]=false;
		return result;
	}
}
