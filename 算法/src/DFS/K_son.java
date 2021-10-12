package DFS;
//����Ϊk������Ӽ�
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
//    			����Ĵ���ʮ�������Ϊ��ʹ��������targetС��Ҳ���ܲ�����ȷ���
//    			����15324,�ȼ���3�������Ǵ�ģ������Ҳû��==target��Ȼ����ͷ�3
//    			������������û������cur==target���ͻ᷵��false���ͷŵ�ǰ�ڵ�
    			flag[i]=true;
    			if(recur(nums, cur+nums[i], target, flag, k, i+1)) return true;
    			flag[i]=false;
    		}
    	}
    	return false;
    }
}
