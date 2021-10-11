package Fight;

import java.util.Scanner;

//现有一序列，长度为n，所有元素均为整数元素。序列中一些元素是确定值，另一些元素是不确定的。 你的任务是将所有不确定值的元素赋予一个正整数值，使得将整个序列分割成最少的段，每一个段都是一个等差数列。 特别的，长度为1和2的段都是等差数列。
//输入包含多组数据，对每组数据第一行包含一个整数n 接下来一行n个整数，空格隔开。如果数为-1,代表该元素不确定，否则该元素为确定值，输入的是这个数的值。
//输出一行一个数，代表分割后最少的段数，使得每一段都是等差数列
public class ShunFeng1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			int n=Integer.parseInt(sc.nextLine());
			String[] nums_str=sc.nextLine().split(" ");
			int[] nums=new int[nums_str.length];
			for(int i=0;i<nums.length;i++) nums[i]=Integer.parseInt(nums_str[i]);
			outer1:for(int i=0;i<nums.length;i++) {
				if(nums[i]==-1) {
					int j=i,k=i;
					System.out.println(j);
					while(j>=0&&nums[j]==-1) j--;
					if(j>=1) {
						nums[j]=nums[j-1];
						continue outer1;
					}
					while(k<nums.length&&nums[k]==-1) k++;
						if(k<nums.length-1) {
							nums[k]=nums[k+1];
							continue outer1;
						}
					}
					nums[i]=1;
			}
			int result=1;
			for(int i=0;i<nums.length-1;i++) {
				if(nums[i]!=nums[i+1]-1) result++;
			}

			System.out.println(result);
			
		}
	}
}
