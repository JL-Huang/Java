package Fight;

import java.util.Scanner;

public class T360_1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		outer:while(sc.hasNextLine()) {
			String str=sc.nextLine();
			boolean[] flag=new boolean[5];
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)>='0'&&str.charAt(i)<='9') flag[0]=true;
				if(str.charAt(i)>='A'&&str.charAt(i)<='Z') flag[1]=true;
				if(str.charAt(i)>='a'&&str.charAt(i)<='z') flag[2]=true;
				if((str.charAt(i)>=33&&str.charAt(i)<=47)||(str.charAt(i)>=58&&str.charAt(i)<=64)||(str.charAt(i)>=91&&str.charAt(i)<=95)) flag[3]=true;
				if(str.length()>=8) flag[4]=true;
			}
			for(int i=0;i<5;i++) {
				if(!flag[i]) {
					System.out.println(i);
					System.out.println("Irregular password");
					continue outer;
				}
			}
			System.out.println("Ok");
		}
	}
}
