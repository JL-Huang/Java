package DFS;
//划分为k个相等子集
public class K_son {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (maxNum < nums[i]) maxNum = nums[i];
        }
        if (sum % k != 0 || maxNum > sum/k) return false;
        boolean[] used = new boolean[nums.length];
        return recur(nums,0,sum/k,used,k,0);
    }
    public boolean recur(int[]nums,int cur,int target,boolean[] flag,int k,int start) {
    	if(k==0) return true;
    	if(cur==target) {
    		return recur(nums, 0, target, flag, k-1, 0);
    	}
    	for(int i=start;i<nums.length;i++) {
    		if(cur+nums[i]<=target&&!flag[i]) {
//    			这里的处理十分巧妙，因为即使加起来比target小，也可能不是正确结果
//    			比如15324,先加了3，但是是错的，到最后也没能==target，然后会释放3
//    			所以如果到最后都没有遇到cur==target，就会返回false，释放当前节点
    			flag[i]=true;
    			if(recur(nums, cur+nums[i], target, flag, k, i+1)) return true;
    			flag[i]=false;
    		}
    	}
    	return false;
    }
}
