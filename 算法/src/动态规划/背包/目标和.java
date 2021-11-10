package 动态规划.背包;
/*
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
示例：
输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5
*/

//假设加法的总和为x，那么减法对应的总和就是-(sum - x)
//所以我们要求的是 x - (sum - x) = S
//x = (S + sum) / 2，也就是需要从数组中挑几个数使其和为x
//此时问题就转化为，装满容量为x背包，有几种方法。
//dp数组定义是填满j（包括j）这么大容积的包，有dp[i]种方法
//虽然从定义到递推都完全不同了，但核心思路两层循环是一样的，看代码里面的注释
//背包种类：一个只能用一次，是零一背包
//背包容量：x
//重量：nums[i]
//价值：无

public class 目标和 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if ((target + sum) % 2 != 0) return 0;
        int size = (target + sum) / 2;
//        注意结果可能为负，为负时取相反数，表示减法数量，一样的
        if (size < 0) size = -size;
        int[] dp = new int[size + 1];
//        初始化，装满容量为0的背包一共有1种方法，就是不装
        dp[0] = 1;
//        尝试把第一件物品放进不同重量的背包，第二件物品又重复这个过程
//        把第一个物品装进去有的背包肯定已经装满了，第一次循环结果[1, 1, 0, 0, 0]
//        第二个物品装的时候，又有一些袋子装满了，结果[1, 2, 1, 0, 0]
        for (int i = 0; i < nums.length; i++) {
//            依然是从大到小，因为大背包是通过小背包求解，如果小背包先装物品i就会导致物品i被重复装
            for (int j = size; j >= nums[i]; j--) {
//                这条式子含义是，容量为j的背包本就有dp[j]种装法
//                来了一个新物品时，如果能装下(j >= nums[i])，则多了j - nums[i]和 nums[i]装一起这种装法
//                而j - nums[i]又有dp[j - nums[i]]种装法，所以累加
                dp[j] += dp[j - nums[i]];
            }
        }
//        注意，dp[size]表示有多少种选法可以使选到的数和为size
        return dp[size];
    }
}
