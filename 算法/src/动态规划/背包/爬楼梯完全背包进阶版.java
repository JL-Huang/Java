package 动态规划.背包;
/*
        假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
        注意：给定 n 是一个正整数。
        示例 1： 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。
        1 阶 + 1 阶
        2 阶
        示例 2： 输入： 3 输出： 3 解释： 有三种方法可以爬到楼顶。
        1 阶 + 1 阶 + 1 阶
        1 阶 + 2 阶
        2 阶 + 1 阶
*/

public class 爬楼梯完全背包进阶版 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }
//      用重量与价值均为1和2的物品装满n的背包
//      完全背包，求排列
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        int[] step = {1, 2};
        dp[0] = 1;
        for (int j = 0; j <= n; j++) {
            for (int i = 0; i < step.length; i++) {
                if (j >= step[i])
                    dp[j] += dp[j - step[i]];
            }
        }
        return dp[n];
    }
}
