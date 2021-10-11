package ½£Ö¸offer;

import java.util.ArrayList;

public class ppp {
	static ArrayList<String> list=new ArrayList<String>();
	public static void main(String[] args) {
		recur("aa", 0, "");
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){System.out.println(list.get(i));}
	}
//	public static ArrayList<String> Permutation(String str) {
//		recur(str, 0, "");
//		return list;
//	}
	private static void recur(String str,int level,String s) {
		if(level==str.length()) {
			list.add(s);
			return;
		}
		for(int i=0;i<str.length();i++) {
			boolean flag=true;
			for(int j=0;j<s.length();j++) {
				if(str.charAt(i)==s.charAt(j)) flag=false;
			}
			if(flag)
			recur(str, level+1, s+str.charAt(i));
		}
	}
}
