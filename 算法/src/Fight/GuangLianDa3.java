package Fight;

import java.util.ArrayList;
import java.util.Scanner;

public class GuangLianDa3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] nums=new int[n];
		ArrayList<Integer>list=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			nums[i]=sc.nextInt();
			list.add(nums[i]);
		}
		for(int i=0;i<n-1;i++) {
			if(list.get(i)==list.get(i+1)) {
				int temp=list.get(i+1)*2;
				list.remove(i+1);
				list.add(i+1,temp);
				list.remove(i);
			}
		}
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}
