package «Ô’–;

import java.util.Scanner;

public class PDD2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] strs=sc.nextLine().split(" ");
		int N=Integer.parseInt(strs[0]);
		int M=Integer.parseInt(strs[1]);
		int[][] input=new int[N][M];
		String[] strs1=new String[M];
		while(sc.hasNextLine()) {
			for(int i=0;i<N;i++) {
				strs1=sc.nextLine().split(" ");
				for(int j=0;j<strs1.length;j++) {
					input[i][j]=Integer.parseInt(strs1[j]);
				}
			}
		}
		int result=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(input[i][j]==1) result++;
			}
		}
		System.out.println(result);
	}
}
