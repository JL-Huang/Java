package 秋招;

import java.util.Scanner;

public class ZhongXing2 {
	static int result=0;
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int T=Integer.parseInt(sc.nextLine());
	while(T>0) {
		int n=Integer.parseInt(sc.nextLine());
		String[] a_str=sc.nextLine().split(" ");
		int[] a=new int[a_str.length];
		for(int i=0;i<a.length;i++) a[i]=Integer.parseInt(a_str[i]);
		if(a.length>0&&a.length<=2) {
			System.out.println(0);
			T--;
			continue;
		}
		recur(a, 1, a[1]-a[0]);
		System.out.println(result);
		T--;
	}
	
}
public static void recur(int[] nums,int i,int d) {
	if(i<1||i>nums.length-1) return;
	if(nums[i]==(nums[i-1]+d)) {
		 recur(nums, i+1, d);
		 return;
	}
	if(nums[i]+1==(nums[i-1]+d)) {
		nums[i]++;
		result++;
		recur(nums, i+1, d);
		return;
	}
	if(nums[i]-1==(nums[i-1]+d)){
		nums[i]--;
		result++;
		recur(nums, i+1, d);
		return;
	}
	else {
		result=-1;
		return;
	}
}
}
