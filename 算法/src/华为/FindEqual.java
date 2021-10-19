package 华为;

import java.util.HashMap;

public class FindEqual {
	public int test(int[] nums) {
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i = 1;i < 1000;i++) {
			map.put(i, 0);
		}
		for(int i =0;i < nums.length;i++) {
			map.put(nums[i], map.get(nums[i]) + 1);
		}
		for(int i =0;i < nums.length;i++) {
			if(map.get(nums[i])==2) return nums[i];
		}
		return -1;
	}
}
