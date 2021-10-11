package Fight;

import java.util.HashMap;
import java.util.Scanner;

public class AiQiYi1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] nums_str=sc.nextLine().split(" ");
		int[] nums=new int[nums_str.length];
		for(int i=0;i<nums.length;i++) {
			nums[i]=Integer.valueOf(nums_str[i]);
		}
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		map.put(5, 0);
		map.put(10, 0);
		map.put(20, 0);
		for(int i=0;i<nums.length;i++) {
			if(map.get(5)<0||map.get(10)<0||map.get(20)<0) {
				System.out.println("fasle");
				return;				
			}
			switch (nums[i]) {
			case 5: {
				map.put(5, map.get(5)+1);
				break;
			}
			case 10: {
				if(map.get(5)==0) {
					System.out.println("fasle");
					return;
				}
				else {
					map.put(5, map.get(5)-1);
					map.put(10, map.get(10)+1);
				}
				break;
			}
			case 20: {
				if(map.get(10)==0) {
					if(map.get(5)<3) {
						System.out.println("fasle");
						return;				
					}
					else {
						map.put(5, map.get(5)-3);
						map.put(20, map.get(20)+1);
						break;
					}
				}
				else {
					if(map.get(5)==0) {
						System.out.println("fasle");
						return;		
					}
					else {
						map.put(10, map.get(10)-1);
						map.put(5, map.get(5)-1);
						break;
					}
				}
			}
			} 
		}
		System.out.println("true");
	}
}
