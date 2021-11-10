package 动态规划.背包;

//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
//输入: amount = 5, coins = [1, 2, 5] 输出: 4 解释: 有四种方式可以凑成总金额: 5=5 5=2+2+1 5=2+1+1+1 5=1+1+1+1+1
//示例 2: 输入: amount = 3, coins = [2] 输出: 0 解释: 只用面额2的硬币不能凑成总金额3。
//示例 3: 输入: amount = 10, coins = [10] 输出: 1
public class 零钱兑换II {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
//        这里两个循环的内外顺序很有讲究！
//        这里是物品在外，结果就是一个硬币放进去所有背包之后，这种硬币就再也不会放进背包了
//        假设coins[0] = 1，coins[1] = 5。那么就是先把1加入计算，然后再把5加入计算，得到的方法数量只有{1, 5}这种情况。而不会出现{5, 1}的情况。
//        但是如果重量在外，每次装包都会遍历所有硬币，因此{1, 5} 和 {5, 1}两种情况都会出现
//        也就是前一种求的组合，后一种求的排列
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
