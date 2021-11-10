package 动态规划.背包;

public class 一和零 {
/*
    给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
    请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
    如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
    示例 1：
    输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3 输出：4
    解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
    其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
    示例 2： 输入：strs = ["10", "0", "1"], m = 1, n = 1 输出：2 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
*/

    //    零一背包
//    容量：m、n
//    物品：strs
//    重量：每个元素0与1的数量
//    价值：均为1
//    求：能装下的最大价值
    public static void main(String[] args) {
        一和零 onz = new 一和零();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(onz.findMaxForm(strs, m, n));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
/*          这里说明一下为什么不是像注释掉的这部分代码一样两个维度同步遍历
            情况就好比一个有两个夹层的背包，两个夹层大小可以分别变化，如果像下面的代码一样那就是只能两个夹层同步变化*/

//            for (int j = m, k = n; j >= getZero(strs[i]) && k >= getOne(strs[i]); j--, k--) {
//                dp[j][k] = Math.max(dp[j][k], dp[j - getZero(strs[i])][k - getOne(strs[i])] + 1);
//            }
            for (int j = m; j >= getZero(strs[i]); j--) {
                for (int k = n; k >= getOne(strs[i]); k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - getZero(strs[i])][k - getOne(strs[i])] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int getZero(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                result++;
            }
        }
        return result;
    }

    private int getOne(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }
}
