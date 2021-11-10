package 动态规划.背包;
//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//注意: 每个数组中的元素不会超过 100 数组的大小不会超过 200
//示例 1: 输入: [1, 5, 11, 5] 输出: true 解释: 数组可以分割成 [1, 5, 5] 和 [11].
//示例 2: 输入: [1, 2, 3, 5] 输出: false 解释: 数组不能分割成两个元素和相等的子集.

//只有确定了如下四点，才能把01背包问题套到本题上来。
//背包的体积为sum / 2
//背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
//背包如何正好装满，说明找到了总和为 sum / 2 的子集。
//背包中每一个元素是不可重复放入。
public class 分割等和子集 {
    public static void main(String[] args) {
        int[] nums={1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int each : nums) {
            sum += each;
        }
        if (sum % 2 != 0) return false;
        int[] dp = new int[sum / 2 + 1];
//        直接套背包公式
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
//        问题来了，怎么让背包的结果往题目靠拢
//        dp[j]表示容量为j的背包最多能装价值多少的物品，如果价值为sum/2的背包恰好能装价值为sum/2的物品，说明满足条件
        return dp[sum / 2] == sum / 2;
    }
}
