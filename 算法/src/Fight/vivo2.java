package Fight;

import java.util.Scanner;

public class vivo2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		if(judge(str)) {
			System.out.println(str);
			return;
		}
		for(int i=0;i<str.length()-1;i++) {
			String new_str=str.replace(str.charAt(i), '@');
			String[] strs=new_str.split("@");
			String real=strs[0]+strs[1];
			if(judge(real)) {
				System.out.println(real);
				return;
			}
		}
		if(judge(str.substring(0,str.length()-1))) {
			System.out.println(str.substring(0,str.length()-1));
			return;
		}
		System.out.println(false);
	}
	public static boolean judge(String a) {
		if(a.length()==1) return false;
		for(int i=0;i<a.length()/2;i++) {
			if(a.charAt(i)!=a.charAt(a.length()-1-i))
				return false;
		}
		return true;
	}
}
