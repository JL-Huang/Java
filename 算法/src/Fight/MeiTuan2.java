package Fight;
//找数组中的平衡点
public class MeiTuan2 {
	public static void main(String[] args) {
		MeiTuan2 m=new MeiTuan2();
		int nums[]= {3,2,1,5,2};
		System.out.println(m.balance(nums));
	}
	public int balance(int[] nums) {
		int length=nums.length;
		int sum=nums[0]-nums[length-1];
		for(int i=0,j=length-1;i<j;) {
			if(sum>0) sum-=nums[--j];
			if(sum<0) sum+=nums[++i];
			if(sum==0) return i;
		}
		return -1;
	}
}
