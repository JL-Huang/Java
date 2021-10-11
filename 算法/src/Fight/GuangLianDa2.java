package Fight;

import java.util.Scanner;

public class GuangLianDa2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		double C=sc.nextDouble();
		sc.nextLine();
		double[] c=new double[n];
		int[] w=new int[n];
		for(int i=0;i<n;i++) {
			String[] nums=sc.nextLine().split(" ");
			c[i]=Double.parseDouble(nums[0]);
			w[i]=Integer.parseInt(nums[1]);
		}
		int[][] result=new int[n+1][(int) C+1];
		for(int i=1;i<=n;i++) {
//			result[i]=result[i-1]+(C-c[i-1]>=0?w[i-1]:0);
			for(int j=(int) C;j>=0;j--) {
				if(j-c[i-1]<0) result[i][j]=result[i-1][j];
				else result[i][j]=Math.max(result[i-1][j],result[i-1][(int) (j-c[i-1])]+w[i-1]);
				
			}
		}
		System.out.println(result[n][(int) C]);
	}
}
