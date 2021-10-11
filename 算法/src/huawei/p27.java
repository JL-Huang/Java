package huawei;

import java.util.LinkedList;
import java.util.Scanner;

public class p27 {
public static void main(String[] args) {
	LinkedList<Integer> list=new LinkedList<Integer>();
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	for(int i=1;i<num+1;i++) {
		list.add(i);
	}
	for(int i=1;i<Integer.MAX_VALUE;i++) {
		int temp=i;
		if(temp+i-1>=list.size())	temp=list.size()-i;
		list.remove(list.get(temp+i-1));
		System.out.println(list.toString());
		if(list.size()==1) {
			System.out.println(list.get(0));
			return;
		}
	}
}
}
