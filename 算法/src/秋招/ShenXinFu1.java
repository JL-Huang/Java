package ÇïÕÐ;

import java.util.Arrays;
import java.util.Scanner;

public class ShenXinFu1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] strs=sc.nextLine().split(" ");
		String source=strs[0];
		int index=Integer.parseInt(strs[1]);
		if(source.length()!=8||index>source.length()||index<=0) {
			System.out.println("error");
			return;
		}
		for(int i=0;i<source.length();i++) {
			if(source.charAt(i)<'0'||source.charAt(i)>'9') {
				System.out.println("error");
				return;
			}
		}
		String[] nums=source.split(String.valueOf(source.charAt(index-1)));
		String add=nums.length==2?nums[0]+nums[1]:nums[0];
		int[] add_num=new int[add.length()];
		for(int i=0;i<add.length();i++) {
			add_num[i]=add.charAt(i)-'0';
		}
		Arrays.sort(add_num);
		for(int i=0;i<add_num.length;i++) {
			System.out.print(add_num[add_num.length-1-i]);
		}
	}
}
