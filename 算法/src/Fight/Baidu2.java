package Fight;

import java.util.Scanner;

public class Baidu2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] nums_str=sc.nextLine().split(" ");
		int x=Integer.parseInt(nums_str[0]);
		int y=Integer.parseInt(nums_str[1]);
		int[][] matrix=new int[x][y];
		String[] nums_row_strs=new String[y];
		for(int i=0;i<x;i++) {
			nums_row_strs=sc.nextLine().split(" ");
			for(int j=0;j<y;j++) {
				matrix[i][j]=Integer.parseInt(nums_row_strs[j]);
			}
		}
		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				if(j>=1&&j<x-1&&i>=1&&i<y-1) 
					matrix[j][i]=(int)(matrix[j-1][i]+matrix[j+1][i]+matrix[j][i-1]+matrix[j][i+1]+matrix[j][i]+2.5)/5;
				else if(j<1&&j<x-1&&i>=1&&i<y-1)
					matrix[j][i]=(int)(matrix[j+1][i]+matrix[j][i-1]+matrix[j][i+1]+matrix[j][i]+2)/4;
				else if(j>=1&&j>=x-1&&i>=1&&i<y-1) 
					matrix[j][i]=(int)(matrix[j-1][i]+matrix[j][i-1]+matrix[j][i+1]+matrix[j][i]+2)/4;
				else if(j>=1&&j<x-1&&i<1&&i<y-1) 
					matrix[j][i]=(int)(matrix[j-1][i]+matrix[j+1][i]+matrix[j][i+1]+matrix[j][i]+2)/4;
				else if(j>=1&&j<x-1&&i>=1&&i>=y-1) 
					matrix[j][i]=(int)(matrix[j-1][i]+matrix[j+1][i]+matrix[j][i-1]+matrix[j][i]+2)/4;
				else if(j<1&&j<x-1&&i<1&&i<y-1) 
					matrix[j][i]=(int)((matrix[j+1][i]+matrix[j][i+1]+matrix[j][i]+1.5)/3);
				else if(j<1&&j<x-1&&i>=1&&i>=y-1) 
					matrix[j][i]=(int)((matrix[j+1][i]+matrix[j][i-1]+matrix[j][i]+1.5)/3);
				else if(j>=1&&j>=x-1&&i>=1&&i>=y-1) 
					matrix[j][i]=(int)((matrix[j-1][i]+matrix[j][i-1]+matrix[j][i]+1.5)/3);
				else if(j>=1&&j>=x-1&&i<1&&i<y-1) 
					matrix[j][i]=(int)((matrix[j-1][i]+matrix[j][i+1]+matrix[j][i]+1.5)/3);
				else if(j<1&&j>=x-1&&i<1&&i>=y-1) 
					matrix[j][i]=matrix[j][i];
			}
		}
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
