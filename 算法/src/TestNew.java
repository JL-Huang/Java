import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

public class TestNew {
    public static void main(String[] args) {
        test();
    }

    public static int test() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int price = 12;
//        dp[i][j]表示前i个凑出价格不大于j的组合数量
//        dp[i][j]=max(dp[i-1][j-nums[i]]*2+1,1);

//        dp[i][nums[0]]=1;
        int[][] dp = new int[nums.length][price + 1];
        if (nums[0] > price) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0]; j++) {
                dp[i][j] = 0;
            }
            dp[i][nums[0]] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = nums[0]; j < price+1; j++) {
                if (j - nums[i] < 0) {
                    dp[i][j]=dp[i - 1][nums[i-1]];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j - nums[i]] * 2 , 0)+1;
                }
            }
        }
        return dp[dp.length-1][price];
    }
}
