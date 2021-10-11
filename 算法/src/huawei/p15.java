package huawei;

import java.util.HashMap;
import java.util.Scanner;

public class p15 {
public static void main(String[] args) {
System.out.println(String.valueOf(test()));
}
public static HashMap<Character, Integer> gethashmap(String str){
	HashMap<Character, Integer> map=new HashMap<Character, Integer>();
	char[] chars=str.toCharArray();
	for(Character temp:chars) {
		if(map.containsKey(temp)) {		
			Integer i=map.get(temp);
			map.put(temp, ++i);
		}
		if(!map.containsKey(temp)) {
			map.put(temp, 1);
		}
	}
	return map;
}
public static boolean test() {
	Scanner sc=new Scanner(System.in);
	String str1=sc.nextLine();
	String str2=sc.nextLine();
	HashMap<Character, Integer>map1=gethashmap(str1);
	HashMap<Character, Integer>map2=gethashmap(str2);
	char[] chars=str2.toCharArray();
	for(int i=0;i<chars.length;i++) {
		if(!map1.containsKey(chars[i]))
			return false;
		System.out.println(map2.get(chars[i]));
		System.out.println(map1.get(chars[i]));
		if(map2.get(chars[i])>map1.get(chars[i]))
			return false;
	}
	str1.equals(str2);
	return true;
}
}
