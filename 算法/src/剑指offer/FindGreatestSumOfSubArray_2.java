package 剑指offer;

public class FindGreatestSumOfSubArray_2 {
	public static void main(String[] args) {
		int[] nums= {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new FindGreatestSumOfSubArray_2().maxSubArray(nums));
	}
    public int maxSubArray(int[] nums) {
        int tempresult=0,k=0,result=Integer.MIN_VALUE;
        while(k<nums.length) {
        	if(tempresult<0) tempresult=nums[k];
        	else tempresult+=nums[k];
        	k++;
        	result=result>tempresult?result:tempresult;
        }
        return result;
    }
}
