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
//	不同的子问题：对于每一index，都要求index结尾的子序列长度最大值length[index]
//	公共子子问题：每一个解都可以通过length[index-1]求出
//	可以保存的内容：length[index-1]
//    思路是用result[i]保存以nums[i]结尾的子序列长度最大值
//    result[i]=max(result[0~i-1])
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
