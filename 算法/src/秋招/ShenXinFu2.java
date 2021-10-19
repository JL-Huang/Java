package 秋招;

import java.util.Scanner;

public class ShenXinFu2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[][] nums=new int[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				nums[i][j]=sc.nextInt();
			}
		}
		int[][] result=new int[5][5];
		for(int i=1;i<5;i++) {
			for(int j=1;j<5;j++) {
				if(i==1) result[i][j]=result[i][j-1]+nums[0][j-1];
				if(j==1) result[i][j]=result[i-1][j]+nums[i-1][0];
				if(i!=1&&j!=1) result[i][j]=Math.min(result[i-1][j], result[i][j-1])+nums[i-1][j-1];
			}
		}

		System.out.println(result[4][4]);
	}
}
