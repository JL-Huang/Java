package 秋招;

import java.util.Scanner;

public class BeiKe1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		for(;n>0;n--) {
			String[] strs=sc.nextLine().split(" ");
			char[] chars=new char[strs.length];
			for(int i=0;i<strs.length;i++) {
				chars[i]=strs[i].charAt(0);
			}
			int p_left=0,p_right=0;
			if(chars[2]=='S') {
				if(chars[0]=='J') p_left-=1;
				if(chars[0]=='S') p_left-=1;
				if(chars[0]=='B') p_left+=1;
				if(chars[1]=='J') p_right-=1;
				if(chars[1]=='S') p_right-=1;
				if(chars[1]=='B') p_right+=1;
			}
			if(chars[2]=='B') {
				if(chars[0]=='J') p_left+=1;
				if(chars[0]=='S') p_left-=1;
				if(chars[0]=='B') p_left-=1;
				if(chars[1]=='J') p_right+=1;
				if(chars[1]=='S') p_right-=1;
				if(chars[1]=='B') p_right-=1;
			}
			if(chars[2]=='J') {
				if(chars[0]=='J') p_left-=1;
				if(chars[0]=='S') p_left+=1;
				if(chars[0]=='B') p_left-=1;
				if(chars[1]=='J') p_right+=0;
				if(chars[1]=='S') p_right+=1;
				if(chars[1]=='B') p_right-=1;
			}
			if(chars[3]=='S') {
				if(chars[0]=='J') p_left-=1;
				if(chars[0]=='S') p_left-=1;
				if(chars[0]=='B') p_left+=1;
				if(chars[1]=='J') p_right-=1;
				if(chars[1]=='S') p_right-=1;
				if(chars[1]=='B') p_right+=1;
			}
			if(chars[3]=='B') {
				if(chars[0]=='J') p_left+=1;
				if(chars[0]=='S') p_left-=1;
				if(chars[0]=='B') p_left-=1;
				if(chars[1]=='J') p_right+=1;
				if(chars[1]=='S') p_right-=1;
				if(chars[1]=='B') p_right-=1;
			}
			if(chars[3]=='J') {
				if(chars[0]=='J') p_left-=1;
				if(chars[0]=='S') p_left+=1;
				if(chars[0]=='B') p_left-=1;
				if(chars[1]=='J') p_right-=1;
				if(chars[1]=='S') p_right+=1;
				if(chars[1]=='B') p_right-=1;
			}
			if(p_left==p_right) {
				System.out.println("same");
				continue;
			}
			System.out.println(p_left>p_right?"left":"right");
		}
	}
}
