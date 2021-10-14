package «Ô’–;

import java.util.Arrays;
import java.util.Scanner;

public class MT4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		outer1:while(sc.hasNextLine()) {
			Integer n=Integer.parseInt(sc.nextLine());
			String[] nums_str=sc.nextLine().split(" ");
			int[] nums=new int[n];
			for(int i=0;i<n;i++) nums[i]=Integer.valueOf(nums_str[i]);
			Arrays.sort(nums);
			int level=nums[0]*2/(n+1); 
			for(int i=0;i<n;i++) {
				int cur_level=(int) Math.log(i+1);
				if(nums[i]!=n-1/Math.pow(2, cur_level)) {
					System.out.println("NO");
					continue outer1;
				}
			}
			System.out.println("YES");
		}
	}
}
