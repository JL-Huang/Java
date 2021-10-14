package »ªÎª;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Test {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String str=sc.nextLine();
	String[] strs=str.split(",");
	Set<String> set=new HashSet<String>();
	for(String temp:strs) {
		for(int i=1;i<temp.length();i++) {
			if(temp.charAt(0)>96||temp.charAt(i)<97) {
			System.out.println("error.0001");
			return;
		}
		}
		set.add(temp);
	}
	String[] strss=new String[set.size()];
	set.toArray(strss);
	
	int[] nums=new int[strss.length];
	for(String temp:strss) {
	for(int i=0;i<strs.length;i++) {
		for(int j=0;j<strss.length;j++) {
			if(strss[j].equals(strs[i])) {
				nums[j]++;
			}
		}
	}
	}
	int maxnum=0;
	for(int i=0;i<nums.length;i++) {
		maxnum=nums[i]>maxnum?nums[i]:maxnum;
	}
	Set<String> set1=new HashSet<String>();
	for(int i=0;i<nums.length;i++) {
		if(maxnum==nums[i]) {
			set1.add(strss[i]);
		}
	}

	String[] winner=new String[set1.size()];
	set1.toArray(winner);
	List<String>list=new ArrayList<String>();
	for(int i=0;i<winner.length;i++) {
		list.add(winner[i]);
	}
	Collections.sort(list);
	System.out.println(list.get(0));
	}
}


