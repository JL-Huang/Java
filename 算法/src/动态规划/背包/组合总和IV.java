package 动态规划.背包;

public class 组合总和IV {
    /*
        给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
        示例:
        nums = [1, 2, 3] target = 4
        所有可能的组合为： (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2, 2) (3, 1)
        请注意，顺序不同的序列被视作不同的组合。
        因此输出为 7。
    */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
//        dp[0] = 1 其实没有意义,单纯是为了数组初始化
//        如果要有意义，应该是让dp[k]=nums[0]>k?1:0;然后循环从k+1开始，这里是取巧了，因为dp[k]的取值肯定就是dp[0]
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i])
                    dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
