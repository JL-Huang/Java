package Fight;

import java.util.Scanner;

public class PDD3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] strs=sc.nextLine().split(" ");
		int N=Integer.parseInt(strs[0]);
		int M=Integer.parseInt(strs[1]);
		int[][] input=new int[N][2];
		for(int i=0;i<N;i++) {
			strs=sc.nextLine().split(" ");
			input[i][0]=Integer.parseInt(strs[0]);
			input[i][1]=Integer.parseInt(strs[1]);
		}
		System.out.println(recur(input, M, N));
	}
	public static int recur(int[][] input,int M,int N) {
		int Max_C=M;
		int Max_V=0;
		boolean[] flag=new boolean[N];
		for(int i=0;i<N;i++) {
			if (input[i][0]<=0&&input[i][1]>=0) {
				Max_C=Max_C-input[i][0];
				Max_V=Max_V+input[i][1];
				flag[i]=true;
			}
		}
		for(int i=0;i<N;i++) {
			if(input[i][1]>=0&&Max_C-input[i][0]>=0&&flag[i]==false) {
				Max_C=Max_C-input[i][0];
				Max_V=Max_V+input[i][1];
				flag[i]=true;
			}
			if(Max_C<0) {
				if(input[i][0]<=0&&flag[i]==false) {
					Max_C=Max_C-input[i][0];
					Max_V=Max_V+input[i][1];
					flag[i]=true;
				}
			}
		}
		return Max_V;
	}
}
