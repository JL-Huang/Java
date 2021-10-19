package 秋招;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class WangYi3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		map.put('a', 0);
		map.put('b', 0);
		map.put('c', 0);
		map.put('x', 0);
		map.put('y', 0);
		map.put('z', 0);
		String str=sc.nextLine();
		int[] max_length=new int[str.length()+1];
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='a'||str.charAt(i)=='b'||str.charAt(i)=='c'||
					str.charAt(i)=='x'||str.charAt(i)=='y'||str.charAt(i)=='z') {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
				if(map.get(str.charAt(i))%2==0) {
					max_length[i+1]=max_length[i]+1;
				}
				else {
					max_length[i+1]=str.indexOf(str.charAt(i))==-1?max_length[i]:i-str.indexOf(str.charAt(i));
				}
			}
			else max_length[i+1]=max_length[i]+1;;
		}
		Arrays.sort(max_length);
		System.out.println(max_length[max_length.length-1]);
	}
}
