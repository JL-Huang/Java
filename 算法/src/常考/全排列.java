package ����;
//ȫ���У��������+��֦

import java.util.ArrayList;

public class ȫ���� {
	static ArrayList<ArrayList<Character>> list=new ArrayList<ArrayList<Character>>();
	public static void main(String[] args) {
		ȫ���� permutation=new ȫ����();
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
//	ȫ���о�������Ĵ��룬�������ȫ�����������ظ���
//	������for����ӵ�ǰλ��Ȼ��ݹ飬�ݹ����ǵû��ˣ���Ϊֻ��һ��inner_list��Ҫ����
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
//	 �������ȥ�ش��룬����һ����־����flag����������ÿ�ε�flag=true�Ͳ�ѭ���ˣ���ÿ�εݹ�ǰ���ѵ�ǰi��Ϊtrue���ݹ�ʱ�ͻ�����
//	 ���Ǽǵõݹ�֮��Ҫ�����������ݹ��ȫ����־λ������true
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
