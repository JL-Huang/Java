package ÇïÕÐ;

import java.util.Scanner;

public class BeiKe3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		for(;n>0;n--) {
			int num=Integer.parseInt(sc.nextLine());
			String[] name=new String[num];
			int[] big=new int[num];
			int[] small=new int[num];
			for(int i=0;i<num;i++) {
				String[] strs=sc.nextLine().split(" ");
				name[i]=strs[0];
				big[i]=Integer.parseInt(strs[1]);
				small[i]=Integer.parseInt(strs[2]);
			}
			String[] result=new String[num];
			for(int i=1;i<num;i++) {
				for(int j=num-1;j>=i;j--) {
					if(big[j]>big[j-1]) {
						int temp1=big[j];
						big[j]=big[j-1];
						big[j-1]=temp1;
						String temp2=name[j];
						name[j]=name[j-1];
						name[j-1]=temp2;
						int temp3=small[j];
						small[j]=small[j-1];
						small[j-1]=temp3;
					}
				}
			}
			for(int i=0;i<num;i++)
			System.out.print(name[i]+" ");
		}
	}
}
