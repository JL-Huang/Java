package 剑指offer;

import java.util.ArrayList;

public class Permutation {
	public static void main(String[] args) {
		Permutation permutation=new Permutation();
		permutation.test("abc");
	}
	 public ArrayList<String> test(String str) {
		 ArrayList<String>list=new ArrayList<String>();
	       char[] chars= str.toCharArray();
	       recur(list, 0, str.length(), chars);
	       list.sort(null);
	       for(String temp:list) System.out.println(temp);
	       return list;
	    }
	 public void recur(ArrayList<String> list,int depth,int target,char[] chars) {
		 if(depth==target-1) {
			 if(!list.contains(String.copyValueOf(chars))) list.add(String.copyValueOf(chars));
			 return;
		 }
		 for(int i=0;i<chars.length;i++) {
			 swap(chars,depth,i);
			 recur(list,depth+1,target,chars);
			 swap(chars,i,depth);
		 }
	 }
	 private void swap(char[]chars,int i,int j) {
		 char temp=chars[i];
		 chars[i]=chars[j];
		 chars[j]=temp;
	 }
}
