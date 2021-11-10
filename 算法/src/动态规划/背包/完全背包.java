package 动态规划.背包;

public class 完全背包 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWight = 4;
        System.out.println(test1(weight, value, bagWight));
    }
//    这是物品在外重量在内的版本
    public static int test1(int[] weight, int[] value, int W){
        int[] dp = new int[W + 1];
        for (int i = 0; i < weight.length; i++){
//            这里j的初值可以直接赋值weight[i]，这样子可以省略判断
            for (int j = 1; j <= W; j++){
                if (j - weight[i] >= 0){
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
        return dp[W];
    }
//    这是重量在外物品在内的版本
    public static int test2(int[] weight, int[] value, int W){
        int[] dp = new int[W + 1];
        for (int i = 1; i <= W; i++){
            for (int j = 0; j < weight.length; j++){
                if (i - weight[j] >= 0){
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }
        return dp[W];
    }
}
