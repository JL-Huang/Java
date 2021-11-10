package 动态规划.背包;
/*给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
如果没有任何一种硬币组合能组成总金额，返回 -1。
你可以认为每种硬币的数量是无限的。
示例 1： 输入：coins = [1, 2, 5], amount = 11 输出：3 解释：11 = 5 + 5 + 1
示例 2： 输入：coins = [2], amount = 3 输出：-1
示例 3： 输入：coins = [1], amount = 0 输出：0
示例 4： 输入：coins = [1], amount = 1 输出：1
示例 5： 输入：coins = [1], amount = 2 输出：2*/

//完全背包
//dp[amount]含义：装满容量为amount的背包的最小价值
//重量：coins[i]
//价值：1
//递推：dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
public class 零钱兑换 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
//        注意，最小的物品数，那就需要把初值赋值为max
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }
//        这里一定要对dp[0]初始化，金额0需要0个硬币
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
//                每次拿到一枚新面额的硬币时，找零的硬币数是Math.min(初值，没拿到当前的硬币时的找零方法+1)
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
//        如果不能找零，那必然还是初值
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}
