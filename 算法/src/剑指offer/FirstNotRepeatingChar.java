package 剑指offer;

import java.util.HashMap;

//在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
//如果没有则返回 -1（需要区分大小写）（从0开始计数）
public class FirstNotRepeatingChar {
    public int test(String str) {
//    	思路就是map，以字母为键，出现次数为值。两次遍历，一次存值，一次查值
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<str.length();i++) {
//        	这里有点技巧，先尝试去查，查不到就给1，查得到就加一
        	if(map.get(str.charAt(i))!=null) 
        		map.put(str.charAt(i), map.get(str.charAt(i))+1);
        	else map.put(str.charAt(i), 1);
        }
        for(int i=0;i<str.length();i++) {
        	if(map.get(str.charAt(i))==1) return i;
        }
        return -1;
    }
}
