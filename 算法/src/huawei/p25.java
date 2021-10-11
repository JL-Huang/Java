package huawei;


import java.util.Scanner;

public class p25{
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String s=sc.nextLine();
	String max=s.substring(0, 1);
	String temp=null;
	boolean flag=false;
	for(int i=0;i<s.length()-1;i++) {
		for(int j=i+1;j<s.length();j++) {
			temp=s.substring(i, j+1);
			if(check(temp)) {
				flag=true;
				max=max.length()>=temp.length()?max:temp;
			}
		}
	}
    if(!flag) {
    	System.out.println("null");
    	return;
    }
	System.out.println(max);
}
private static boolean check(String s) {
	char[] chars=s.toCharArray();
	for(int i=0;i<chars.length/2;i++) {
		if(chars[i]!=chars[chars.length-1-i])
		return false;
	}
	return true;
}
}
