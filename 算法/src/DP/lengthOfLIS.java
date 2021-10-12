package DP;
//�����������
import java.util.Arrays;

public class lengthOfLIS {
//	��̬�滮�����Žⲻ������ȷ����һ��
	
	public static void main(String[] args) {
		lengthOfLIS l=new lengthOfLIS();
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
//    ˼·����result[i]������nums[i]��β�������г������ֵ
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
//    int binarySearch(int[] result,int length,int key) {
//    	int low=0,high=length-1,middle;
//    	while(low<=high) {
//    		middle=(low+high)/2;
//    		if(result[middle]>key) high=middle-1;
//    		else if(result[middle]<key) low=middle+1;
//    		else return middle;
//    	}
//    	return low;
//    }
}
