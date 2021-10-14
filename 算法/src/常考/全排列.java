package 常考;
//全排列，经典回溯+剪枝

import java.util.ArrayList;

public class 全排列 {
	static ArrayList<ArrayList<Character>> list=new ArrayList<ArrayList<Character>>();
	public static void main(String[] args) {
		全排列 permutation=new 全排列();
		char[] chars=new String("abc").toCharArray();
		permutation.permute(chars);
		for(ArrayList<Character> temp:list) {
			System.out.println(temp.toString());
		}
	}
	public void permute(char[] chars) {
		ArrayList<Character> inner_list=new ArrayList<Character>();
		boolean[] flag=new boolean[chars.length];
//		recur1(inner_list, chars);
		recur2(inner_list, chars,flag);
	}
//	全排列就是下面的代码，但是这个全排列是允许重复的
//	就是在for里添加当前位，然后递归，递归完后记得回退，因为只有一个inner_list，要复用
	 private void recur1(ArrayList<Character> inner_list,char[] chars) {
		 if(inner_list.size()==chars.length) {
			 this.list.add(new ArrayList<Character>(inner_list));
			 return;
		 }
		 for(int i=0;i<chars.length;i++) {
			 inner_list.add(chars[i]);
			 recur1(inner_list, chars);
			 inner_list.remove(inner_list.size()-1);
		 }
	 }
//	 而这个是去重代码，用了一个标志数组flag，这个很巧妙，每次当flag=true就不循环了，而每次递归前，把当前i设为true，递归时就会跳过
//	 但是记得递归之后还要变回来，否则递归把全部标志位都会变成true
	 private void recur2(ArrayList<Character> inner_list,char[] chars,boolean[] flag) {
		 if(inner_list.size()==chars.length) {
			 this.list.add(new ArrayList<Character>(inner_list));
			 return;
		 }
		 for(int i=0;i<chars.length;i++) {
			 if(flag[i]==true) continue;
			 flag[i]=true;
			 inner_list.add(chars[i]);
			 recur2(inner_list, chars,flag);
			 flag[i]=false;
			 inner_list.remove(inner_list.size()-1);
		 }
	 }
}
