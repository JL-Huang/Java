package Fight;

import java.util.Scanner;

public class YuanFuDao1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int[] nums=new int[N];
		for(int i=0;i<N;i++) {
			nums[i]=sc.nextInt();
		}
		for(int i=0;i<M;i++) {
			int[] nums_1=new int[N/2];
			int[] nums_2=new int[N-N/2];
			for(int j=0;j<N/2;j++) {
				nums_1[j]=nums[j];
				System.out.print("num1"+nums_1[j]);
				nums_2[j]=nums[j+N/2];
				System.out.print("num2"+nums_2[j]);
				System.out.println();
			}
			if(N%2!=0) nums[N/2+1]=nums[N-1];
			for(int j=0;j<N-1;j+=2) {
				nums[j]=nums_2[j/2];
				nums[j+1]=nums_1[j/2];
			}
		}
		for(int i=0;i<N;i++) {
			System.out.print(nums[i]);
		}
	}

}
