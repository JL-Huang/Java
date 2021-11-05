package 贪心;
//题目看动态规划里的跳跃游戏
public class 跳跃游戏 {
    public static void main(String[] args) {

    }
//    贪心算法
//    全局最优解（能跳跃的最大范围）取决于局部最优解（每走一步能跳跃的最大范围）
//    一直往前一步一步走，每走一步都会更新一次最大范围
    private static boolean iterate(int[] nums) {
        int cover = 0;
        if (nums.length == 1) return true; // 只有一个元素，就是能达到
        for (int i = 0; i <= cover; i++) { // 注意这里是小于等于cover
            cover = Math.max(i + nums[i], cover);
            if (cover >= nums.length - 1) return true; // 说明可以覆盖到终点了
        }
        return false;
    }
}
