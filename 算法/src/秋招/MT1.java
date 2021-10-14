package «Ô’–;

import java.util.HashSet;
import java.util.Scanner;

public class MT1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] nums_str=sc.nextLine().split(" ");
		int n=Integer.valueOf(nums_str[0]);
		int p=Integer.valueOf(nums_str[1]);
		int q=Integer.valueOf(nums_str[2]);
		String[] A_str=sc.nextLine().split(" ");
		int[]A=new int[p];
		for(int i=0;i<p;i++) A[i]=Integer.valueOf(A_str[i]);
		String[] B_str=sc.nextLine().split(" ");
		int[]B=new int[q];
		for(int i=0;i<q;i++) B[i]=Integer.valueOf(B_str[i]);
		HashSet<Integer> set=new HashSet<Integer>();
		for(int i=0;i<p;i++) {
			set.add(A[i]);
		}
		for(int i=0;i<q;i++) {
			set.add(B[i]);
		}
		int r_1=set.size()-q;
		int r_2=set.size()-p;
		int r_3=p+q-set.size();
		System.out.println(r_1+" "+r_2+" "+r_3);
	}
}
