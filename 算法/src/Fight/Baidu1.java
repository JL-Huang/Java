package Fight;

import java.util.Scanner;

public class Baidu1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] nums_str=sc.nextLine().split(" ");
		int x=Integer.parseInt(nums_str[0]);
		int y=Integer.parseInt(nums_str[1]);
		char[] chars=sc.nextLine().toCharArray();
		for(int i=0;i<chars.length;i++) {
			if(chars[i]=='L') x--;
			if(chars[i]=='R') x++;
			if(chars[i]=='U') y++;
			if(chars[i]=='D') y--;
		}
		System.out.println(x+" "+y);
	}
}
