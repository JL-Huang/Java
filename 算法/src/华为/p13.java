package ��Ϊ;

import java.util.ArrayList;
import java.util.List;

public class p13 {

    public static void main(String[] args) {
    	p13 p=new p13();
		System.out.println(p.generateParenthesis(3));
	}
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<String>();
        recur(0,0,n,"",list);
        return list;
    }
    public void recur(int left,int right,int max,String str,List<String> list){
        //�����ж�
        if(left==max&&right==max){
            list.add(str);
            return;
        }
        //��ǰ�߼�
        
//        String s1=str+"(";
//        String s2=str+")";
        //�ݹ�
        if(left<max)
        recur(left+1,right,max,str+"(",list);
        if(left>right)
        recur(left,right+1,max,str+")",list);
    }
}
