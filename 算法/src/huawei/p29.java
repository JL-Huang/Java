package huawei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class p29 {
	public static void main(String[] args) {
		String s="we are one";
		char[] chars=s.toCharArray();
		StringBuilder sb=new StringBuilder();
		for(Character temp:chars) {
			if(temp!=' ') sb.append(temp);
			else {
				sb.append("%20");
			}
		}
		System.out.println(sb.toString());
	}
}
