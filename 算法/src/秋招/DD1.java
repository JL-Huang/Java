package 秋招;

import java.util.HashMap;
import java.util.Scanner;

public class DD1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int total=sc.nextInt();
		for(int i=0;i<total;i++) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			int k=sc.nextInt();
			sc.nextLine();
			int island_1[]=new int[m];
			int island_2[]=new int[m];
			int cost[]=new int[m];
			for(int j=0;j<m;j++) {
				String[] nums_str=sc.nextLine().split(" ");
					island_1[j]=Integer.valueOf(nums_str[0]);
					island_2[j]=Integer.valueOf(nums_str[1]);
					cost[j]=Integer.valueOf(nums_str[2]);
			}
			HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
			for(int j=0;j<m;j++) {
				if(cost[j]>k) continue;
				else {
					map.put(island_1[j], island_2[j]);
				}
			}
			int cur = 0;
			int new_key;
			for(int j=0;j<map.size();j++) {
					if(!map.containsKey(island_1[j])) continue;
					else {
						new_key=map.get(island_1[j]);
						cur=map.get(new_key);
					}
			}
			System.out.println(cur==n?"YES":"NO");
		}
	}
}
//class Bridge{
//	public int val;
//	public Bridge next;
//	public Bridge(int val) {
//		super();
//		this.val = val;
//	}
//	
//}
