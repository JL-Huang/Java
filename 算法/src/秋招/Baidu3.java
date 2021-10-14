package 秋招;

import java.util.Scanner;

public class Baidu3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] nums_str=sc.nextLine().split(" ");
		int n=Integer.parseInt(nums_str[0]);
		int max_n=Integer.parseInt(nums_str[1]);
		int max_money=Integer.parseInt(nums_str[2]);
		int[] price=new int[n];
		int[] weight=new int[n];
		int[] v=new int[n];
		for(int i=0;i<n;i++) {
			String[] strs=sc.nextLine().split(" ");
			price[i]=Integer.parseInt(strs[0]);
			weight[i]=Integer.parseInt(strs[1]);
			v[i]=Integer.parseInt(strs[2]);
		}
		for(int i=0;i<n;i++) {
			for(int j=n-1;j>=i;j--) {
				if(v[j]<v[i]||(v[j]==v[i]&&price[j]<price[i])) {
					int temp1=v[i];
					v[i]=v[j];
					v[j]=temp1;
					int temp2=price[i];
					price[i]=price[j];
					price[j]=temp2;
					int temp3=weight[i];
					weight[i]=weight[j];
					weight[j]=temp3;
				}
			}
		}
//		i是第i个，j是重量不超过j，k是钱不多于k
		int[][][] pack=new int[n+1][max_n+1][max_money+1];
		for(int i=0;i<n+1;i++) {
			pack[i][0][0]=1;
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<max_n+1;j++) {
				for(int k=1;k<max_money+1;k++) {
					if(j-weight[i-1]<0&&k-price[i-1]>=0) pack[i][j][k]=pack[i-1][j][k-price[i-1]];
					else if(j-weight[i-1]>=0&&k-price[i-1]<0) pack[i][j][k]=pack[i-1][j-weight[i-1]][k];
					else if(j-weight[i-1]<0&&k-price[i-1]<0) pack[i][j][k]=pack[i-1][j][k];
					else pack[i][j][k]=pack[i-1][j-weight[i-1]][k-price[i-1]]+1;
				}
			}
		}
		System.out.println(pack[n][max_n][max_money]);
	}
}
//3 10 1000
//100 5 3
//50 3 2
//300 3 3
//2
