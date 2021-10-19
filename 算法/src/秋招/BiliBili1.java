package 秋招;

import java.util.Scanner;

public class BiliBili1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] strs=sc.nextLine().split(" ");
		int[] nums=new int[strs.length];
		int[] weight=new int[strs.length];
		for(int i=0;i<strs.length;i++) {
			nums[i]=Integer.parseInt(strs[i]);
		}
		int init=100000000;
		weight[0]=init;
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i+1]<nums[i]) weight[i+1]=weight[i]-1;
			if(nums[i+1]>nums[i]) weight[i+1]=weight[i]+1;
			if(nums[i+1]==nums[i]) {
				int temp=Integer.MAX_VALUE;
				for(int j=0;j<i+1;j++)temp=weight[j]<=temp?weight[j]:temp;
				weight[i+1]=temp;
			}
		}
		int temp=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++) temp=weight[i]<=temp?weight[i]:temp;
		System.out.println(temp);
		for(int i=0;i<nums.length;i++) weight[i]=weight[i]-temp+1;
		for(int i=0;i<nums.length;i++) System.out.println(weight[i]+" ");
		int result=0;
		for(int i=0;i<nums.length;i++) result+=weight[i];
		System.out.println(result);
	}
}
