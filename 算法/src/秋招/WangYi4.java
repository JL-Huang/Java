package 秋招;

import java.util.Scanner;

public class WangYi4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] nums_str=sc.nextLine().split(" ");
		int[] nums=new int[nums_str.length];
		for(int i=0;i<nums.length;i++) {
			nums[i]=Integer.parseInt(nums_str[i]);
		}
		int[] max=new int[nums.length];
		max[0]=nums[0];
		for(int i=1;i<max.length;i++) {
			max[i]=(max[i-1]+nums[i])%7==0?(max[i-1]+nums[i]):max[i-1];
		}
		int result=0;
		for(int i=0;i<nums.length;i++) {
			result+=nums[i];
		}
		System.out.println(result/7*7);
	}
}
