package ��̬�滮;
//�����������
import java.util.Arrays;

public class ����������� {
//	��̬�滮�����Žⲻ������ȷ����һ��
	
	public static void main(String[] args) {
		����������� l=new �����������();
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
//	��ͬ�������⣺����ÿһindex����Ҫ��index��β�������г������ֵlength[index]
//	�����������⣺ÿһ���ⶼ����ͨ��length[index-1]���
//	���Ա�������ݣ�length[index-1]
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
}
