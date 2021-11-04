package 动态规划;
//最长上升子序列
import java.util.Arrays;

public class 最长上升子序列 {
//	动态规划，最优解不是马上确定第一步
	
	public static void main(String[] args) {
		最长上升子序列 l=new 最长上升子序列();
		int[] nums={10,9,2,5,3,7,101,18};
		System.out.println(l.lengthOfLIS(nums));
	}
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0) return 0;
    	int[] result=new int[nums.length];
    	Arrays.fill(result, 1);
    	recur(nums, result);
    	Arrays.sort(result);
    	return result[nums.length-1];
    }
//思路：保存"必须包含当前位的最优解"，因为如果是"可以不包含当前位的最优解"，不一定能得到最优解
//最优子结构：
    public void recur(int[]nums,int[] result) {
    	for(int i=0;i<nums.length;i++) {
    		for(int k=i;k>=0;k--) {
    			if(nums[i]>nums[k]) {
    				result[i]=result[i]>result[k]?result[i]:result[k]+1;
    			}
    		}
    		
    	}
    }
}
