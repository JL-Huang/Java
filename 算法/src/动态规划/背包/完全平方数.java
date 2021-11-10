package 动态规划.背包;
/*
        给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
        给你一个整数 n ，返回和为 n 的完全平方数的最少数量 。
        完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
        示例 1： 输入：n = 12 输出：3 解释：12 = 4 + 4 + 4
        示例 2： 输入：n = 13 输出：2 解释：13 = 4 + 9
*/

//完全背包
//dp[j]表示和为j的最小完全平方数数量
//容量：n
//物品：1:sqrt(n)
//重量：nums[i]
//价值：1
//递推：dp[j]=Math.min(dp[j],dp[j-nums[i]+1])
//初始化：全初始化为max，dp[1]=1(划掉);
//顺序：物品在外重量在内，完全背包正序
public class 完全平方数 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }

    public static int numSquares(int n) {
        int[] nums = new int[(int) Math.sqrt(n)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i + 1) * (i + 1);
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }
//        初始化不应该是dp[1] = 1，而是dp[0] = 0
//        如果dp[1]=1，那就是1必须装进来，事实上1是不一定要装进来的
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
            }
        }
        return dp[n];
    }
}
