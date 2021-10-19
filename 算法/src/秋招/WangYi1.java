package 秋招;

import java.util.HashMap;
import java.util.Scanner;

public class WangYi1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		sc.nextLine();
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++) {
			String[] strs=sc.nextLine().split(" ");
			map.put(Integer.valueOf(strs[2]), Integer.valueOf(strs[0]));
		}
		int result=0;
		for(int i=2;i<=m-1;i++) {
			if(map.get(i)==map.get(i+1)&&!map.containsValue(i)&&!map.containsValue(i+1))	result++;
		}
		System.out.println(result);
	}
}
