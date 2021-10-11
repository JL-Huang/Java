package Fight;

import java.util.Scanner;

public class Shunfeng1_1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			int n=Integer.parseInt(sc.nextLine());
			String[] nums_str=sc.nextLine().split(" ");
			int[] nums=new int[nums_str.length];
			for(int i=0;i<nums.length;i++) nums[i]=Integer.parseInt(nums_str[i]);
		}
	}
}
