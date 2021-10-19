package 华为;

import java.util.Scanner;

public class p17 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String str=sc.nextLine();
	String[] strs=str.split("-");
	for(int i=0;i<strs.length;i++) {
		String[] nums=strs[i].split("x^");
		int a=Integer.parseInt(nums[0]);
		System.out.println(String.valueOf(a));
		int b=Integer.parseInt(nums[1]);
		System.out.println(String.valueOf(b));
		
	}
//	int[] a=new int[strs.length/2];
//	int[] b=new int[strs.length/2];
//	for(int i=0;i<strs.length&&i%2==0;i++) {
//		a[i/2]=Integer.parseInt(strs[i]);
//	}
//	for(int i=0;i<strs.length&&i%2==1;i++) {
//		b[i/2]=Integer.parseInt(strs[i]);
//	}
//	for(Integer temp:a)
//		System.out.print(temp);
//	System.out.println("");
//	for(Integer temp:a)
//		System.out.print(temp);
}
}
