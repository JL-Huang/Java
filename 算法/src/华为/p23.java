package 华为;

import java.util.ArrayList;
import java.util.List;

public class p23 {
public static void main(String[] args) {
	List<List<Integer>> ans=new ArrayList<List<Integer>>();
	List<Integer> list=new ArrayList<Integer>();
	int[] nums= {0,1,2};
	recur(ans, 0, nums,list);
	for(List<Integer> temp:ans) {
		for(Integer t:temp)
		System.out.print(t+",");
		System.out.println();
	}
}
//dfs深度优先，对每个元素按是否添加来进行递归
private static void recur(List<List<Integer>> ans,int level,int[]nums,List<Integer> list) {
	if(level==nums.length) {
		ans.add(new ArrayList<Integer>(list));
		return;
	}
	recur(ans, level+1, nums, new ArrayList<Integer>(list));
	list.add(nums[level]);
	recur(ans, level+1, nums, new ArrayList<Integer>(list));
}
}
