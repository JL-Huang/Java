package 动态规划.背包;
/*有一堆石头，每块石头的重量都是正整数。
每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
如果 x == y，那么两块石头都会被完全粉碎； 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。
示例：
输入：[2,7,4,1,8,1] 输出：1
解释： 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]
      组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
      组合 2 和 1，得到 1，所以数组转化为 [1,1,1]， 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。*/

//分割成两堆，让两堆重量尽量接近就能得出最优值,sum/2的背包最多能装多少，其中一堆就是多少
//背包种类：一个只能用一次，是零一背包
//背包容量：sum/2
//重量：石头重量
//价值：石头重量

public class 最后一块石头的重量II {
    public static void main(String[] args) {
        int[] stones = {31,26,33,21,40};
        System.out.println(lastStoneWeightII(stones));
    }

    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int each : stones) {
            sum += each;
        }
        int[] dp = new int[sum / 2 + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = sum / 2; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[sum / 2];
    }
}
