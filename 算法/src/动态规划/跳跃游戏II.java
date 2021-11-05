package 动态规划;

/*跳跃游戏II
        给定一个非负整数数组，你最初位于数组的第一个位置。
        数组中的每个元素代表你在该位置可以跳跃的最大长度。
        你的目标是使用最少的跳跃次数到达数组的最后一个位置。
        示例:
        输入: [2,3,1,1,4]
        输出: 2
        解释: 跳到最后一个位置的最小跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
        说明:
        假设你总是可以到达数组的最后一个位置。*/
public class 跳跃游戏II {
    //    求解：第一个点跳到最后一个点所需要的最小次数
//    重叠子问题：每个点能跳到终点的最小次数，取决于其能跳到的点中离终点跳跃次数最小的点+1
//    递推公式：r[i]=min(r[i+1]:r[i+p[i]])+1, i=n-1:0, r[n-1]=0
    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 0, 1, 4};
        System.out.println(iterate(input));
    }

    private static int iterate(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.MAX_VALUE - 1;
        }
        result[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int temp_min = Integer.MAX_VALUE;
//            在他能跳到的范围中(注意如果能跳到最右点以外仍算最右边)
            for (int j = i; j <= (i + nums[i] > nums.length - 1 ? nums.length - 1 : i + nums[i]); j++) {
                temp_min = temp_min < result[j] ? temp_min : result[j];
            }
            result[i] = temp_min + 1;
        }
        return result[0];
    }
}
