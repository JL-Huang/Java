package 华为;

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
        //跳出判断
        if(left==max&&right==max){
            list.add(str);
            return;
        }
        //当前逻辑
        
//        String s1=str+"(";
//        String s2=str+")";
        //递归
        if(left<max)
        recur(left+1,right,max,str+"(",list);
        if(left>right)
        recur(left,right+1,max,str+")",list);
    }
}
