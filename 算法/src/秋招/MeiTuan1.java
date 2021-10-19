package 秋招;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MeiTuan1 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String str=sc.nextLine();
	String[] strs=str.split(" ");
	int num_of_order=Integer.valueOf(strs[0]);
	int num_of_need=Integer.valueOf(strs[1]);
	String[] orders=new String[num_of_order];
	int[] incomes=new int[num_of_order];
	for(int i=0;i<num_of_order;i++) {
		orders[i]=sc.nextLine();
		String[] temp=orders[i].split(" ");
		incomes[i]=Integer.valueOf(temp[0])+2*Integer.valueOf(temp[1]);
	}
	HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
	for(int i=0;i<incomes.length;i++) {
		map.put(incomes[i], i+1);
		System.out.println(map.get(incomes[i]));
	}
	Arrays.sort(incomes);
	for(int i=incomes.length-1;i>=incomes.length-num_of_need;i--) {
		System.out.println(num_of_need);
		System.out.println(incomes[i]);
//		System.out.print(map.get(incomes[i])+" ");
	}

}
}
