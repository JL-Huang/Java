package 秋招;

import java.util.Arrays;
import java.util.Scanner;

public class Shopee3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] strs=sc.nextLine().split(" ");
		int[] nums=new int[strs.length];
		for(int i=0;i<nums.length;i++) {
			nums[i]=Integer.parseInt(strs[i]);
		}
		int k=Integer.parseInt(sc.nextLine());
		Arrays.sort(nums);
		for(int i=0;i<k;i++) {
			System.out.print(nums[i]+" ");
		}
	}
}
