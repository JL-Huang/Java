package «Ô’–;

import java.util.Scanner;

public class MT2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int num_big = 0,num_small=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)>='A'&&str.charAt(i)<='Z') num_big++;
			if(str.charAt(i)>='a'&&str.charAt(i)<='z') num_small++;
		}
		int result=num_big>num_small?(num_big-num_small)/2:(num_small-num_big)/2;
		System.out.println(result);
	}
}
