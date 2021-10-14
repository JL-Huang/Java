package ÇïÕĞ;

import java.util.Scanner;

public class ShunFeng2 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String[] nums_str1=sc.nextLine().split(" ");
	int n=Integer.parseInt(nums_str1[0]);
	int k=Integer.parseInt(nums_str1[1]);
	String[] nums_str2=sc.nextLine().split(" ");
	int[] nums=new int[n];
	for(int i=0;i<n;i++) nums[i]=Integer.parseInt(nums_str2[i]);
	int total=0;
	for(int i=0;i<k;i++) {
		int total_inner=0;
		for(int j=0;j<n/k;j++) total_inner+=nums[j];
		total+=(total_inner*total_inner);
	}
	int max_income=total*total;
	System.out.print(max_income+" ");
	System.out.print(n%k==0?n/k:n/k+1);
	}
}