package DP;

import java.util.ArrayList;

//N个黑球M个白球，有多少种排列
public class BlackWhite {
	public static void main(String[] args) {
		int N=1,M=5;
		ArrayList<Character>list=new ArrayList<Character>();
		ArrayList<ArrayList<Character>> outer_list=new ArrayList<ArrayList<Character>>();
		recur(outer_list, list, N, M);
		System.out.println(outer_list);
		
	}
	public static void recur(ArrayList<ArrayList<Character>> outer_list,ArrayList<Character>list,int cur_N,int cur_M) {
		if(cur_N<0||cur_M<0) return;
		if(cur_M==0&&cur_N==0&&!outer_list.contains(list)) outer_list.add(list);
		list.add('B');
		recur(outer_list, new ArrayList<Character>(list), cur_N-1, cur_M);
		list.add('W');
		recur(outer_list, new ArrayList<Character>(list), cur_N, cur_M-1);
	}
}
