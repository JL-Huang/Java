package «Ô’–;

import java.util.Arrays;

public class T58_3 {
	public static void main(String[] args) {
		int[] nums= {1,1,2,5,4};
		System.out.println(firstMissingPositive(nums));
	}
    public static int firstMissingPositive (int[] nums) {
        Arrays.parallelSort(nums);
        int begin_index=-1;
        for(int i=0;i<nums.length;i++) {
        		if(nums[i]>=0) {
        			begin_index=i;
        			break;
        	}
        }
        System.out.println(begin_index);
        if(begin_index==0&&nums[0]!=1) return 1;
        if(begin_index==-1) return 1;
        for(int i=begin_index;i<nums.length-1;i++) {
        	if(nums[i]!=nums[i+1]-1&&nums[i]!=nums[i+1]) return nums[i]+1;
        }
        return nums[nums.length-1]+1;
    }
}
