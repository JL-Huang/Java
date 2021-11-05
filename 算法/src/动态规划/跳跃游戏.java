package 动态规划;

/*跳跃游戏
        给定一个非负整数数组，你最初位于数组的第一个位置。
        数组中的每个元素代表你在该位置可以跳跃的最大长度。
        判断你是否能够到达最后一个位置。
        示例 1:
        输入: [2,3,1,1,4]
        输出: true
        解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
        示例 2:
        输入: [3,2,1,0,4]
        输出: false
        解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。*/
public class 跳跃游戏 {
    //    求解：第一个点的最大跳跃范围能否到达最后一个点
//    重叠子问题：每个点的最大跳跃范围，取决于其能跳到的点的最大跳跃范围
//    递推公式：r[i]=max(r[i+1]:r[i+p[i]]) i=n-1:0,r[n-1]=n-1
    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 1, 0, 4};
        System.out.println(iterate(input));
    }

    private static boolean iterate(int[] nums) {
        int[] result = new int[nums.length];
//        最右的点能跳到最右的点
        result[nums.length - 1] = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
//            某个点至少能跳回它本身
            int temp_max = i;
//            某个点在到他能跳到的范围中(注意如果能跳到最右点以外仍算最右边)
            for (int j = i; j <= (i + nums[i] > nums.length - 1 ? nums.length - 1 : i + nums[i]); j++) {
                temp_max = temp_max > result[j] ? temp_max : result[j];
            }
            result[i] = temp_max;
        }
        return result[0] == nums.length - 1;
    }
}
