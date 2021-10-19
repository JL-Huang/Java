package 秋招;

import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JingDong1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		Pattern p=Pattern.compile("[^0-9]");
		Matcher m=p.matcher(str);
		String new_str=m.replaceAll(" ");
		String[] strs=new_str.split(" ");
		HashSet<String> set=new HashSet<String>();
		System.out.println("2019 2020");
		for(String temp:strs) {
			
			if(!temp.equals("")&&Integer.valueOf(temp)>=1000&&Integer.valueOf(temp)<=3999) {
				if(!set.contains(temp)) {
					set.add(temp);
					System.out.print(temp+" ");
				}
			}
		}
	}
}
