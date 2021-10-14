package »ªÎª;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class p21 {
	static HashMap<Character, String> map;
	public static void main(String[] args) {
		p21 p=new p21();
		for(String temp:p.letter("23")) {
			System.out.println(temp);
		}
	}
	public List<String> letter(String dights){
		if(dights==null||dights.length()==0)
		return new ArrayList<String>();
		map=new HashMap<Character, String>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		List<String> list=new LinkedList<String>();
		recur(list,"",dights, 0);
		return list;
		
	}
	public void recur(List<String>list,String s,String dights,int i) {
		if(i==dights.length()) {
			list.add(s);
			return;
		}
		String letters=map.get(dights.charAt(i));
//		recur(list, s, dights, i+1);
		for(int j=0;j<letters.length();j++) {
			recur(list, s+letters.charAt(j), dights, i+1);
		}
	}
}
