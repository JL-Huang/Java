package 秋招;

import java.util.ArrayList;
import java.util.Scanner;

public class HuiLiang1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String element=null;
		while(sc.hasNextLine()) {		
			ArrayList<String> list=new ArrayList<String>();
			while((element=sc.nextLine()).length()!=0) {
				list.add(element);
			}
			int n=list.size();
			System.out.println(n);
			String[] input=new String[n];
			for(int i=0;i<n;i++) input[i]=list.get(i).trim();
			double[] time=new double[n];
			for(int i=0;i<n;i++) {
				String[] temp=input[i].split(" ");
				time[i]=Double.parseDouble(temp[temp.length-1].split("\\(")[0]);
			}
			
			for(int i=0;i<n-1;i++) {
				for(int j=n-1;j>i;j--) {
					if(time[j]<time[j-1]) {
						double temp2=time[j];
						time[j]=time[j-1];
						time[j-1]=temp2;
						String temp1=input[j];
						input[j]=input[j-1];
						input[j-1]=temp1;
					}
				}
			}
			for(int i=0;i<n;i++) {
				System.out.println(input[i]);
			}
		}
	}
}
