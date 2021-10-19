package 常考;
//完全背包问题，无限个数，i种硬币，凑成面值j，有几种方法
//f(i,v)=∑ Mi+1	f(i-1,v-k*Ci)
//			k=0
//显然，这里k=Mi+2那一项必然为0，而//f(i,v-Ci)=∑ Mi+1 f(i-1,v-(k+1)*Ci)=∑ Mi+2 f(i-1,v-k*Ci)=f(i,v)-f(i-1,v)
//										 		k=0					 	 k=1

//状态转移方程dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]]
//dp[i][j]表示i种硬币组成面值j的方法数
public class 完全背包 {
	public static void main(String[] args) {
		int[] coins= {9,41,1};
		int target=8;
//		多开一个位置
		int[][]dp1=new int[coins.length+1][target+1];
		System.out.println(get_num2(dp1, coins, target));
	}
	public static int get_num2(int[][]dp,int[] coins,int target) {
		for(int i=0;i<dp.length;i++) {
			dp[i][0]=1;
		}
//		从1种到n种
		for(int i=1;i<dp.length;i++) {
//			价值从1到target
			for(int j=1;j<target+1;j++) {
//				如果目标价值比当前硬币小，不可能了，只能由i-1种构成
				if(j-coins[i-1]<0) dp[i][j]=dp[i-1][j];
//				除此之外，要么是不选当前硬币，要么是选当前硬币
//				注意这里有坑，但凡涉及coins[i],都要写成[i-1],因为i是往后扩展了一位
				else dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
			}
		}
		return dp[coins.length][target];
	}
}
