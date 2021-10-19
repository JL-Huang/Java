package 剑指offer;

public class Test_1 {
	public static void main(String[] args) {
		int[] nums= {1,4,6,2,3,4,9};
		quick_sort(0, nums.length-1, nums);
		for(int i=0;i<nums.length;i++) {
			System.out.println(nums[i]);
		}
	}
	public static void quick_sort(int begin,int end,int[] nums) {
		int left=begin;
		int right=end;
		int key=nums[begin];
		while(left<right) {
			while(nums[left]<=key) left++;
			while(nums[right]>=key) right--;
			if(left<right) {
				int temp=nums[left];
				nums[left]=nums[right];
				nums[right]=temp;
			}
		}
		int temp=nums[begin];
		nums[begin]=nums[left];
		nums[left]=temp;
		quick_sort(left+1, right, nums);
		quick_sort(begin, left-1, nums);
	}
}
