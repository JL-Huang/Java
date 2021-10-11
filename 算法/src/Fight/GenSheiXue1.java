package Fight;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GenSheiXue1 {


/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
******************************开始写代码******************************/
    static List<List<String>> mergeAccount(List<List<String>> accounts) {
        // 在此处编写实现代码逻辑
    	HashSet<String> set=new HashSet<String>();
    	List<List<String>> result=new ArrayList<List<String>>();
    	int i=0,last=0;
    	for(List<String> temp:accounts) {
        	if(!set.contains(temp.get(0))) {
        		set.add(temp.get(0));
        		result.add(temp);
        		last=i;
        	}else {
        		for(i=1;i<result.get(i).size();i++)
        		result.get(last).add(result.get(i).get(i));
        	}
        	i++;
    	}
        return result;
    }
/******************************结束写代码******************************/


    public static void main(String[] args) {
    	List<List<String>> accounts=new ArrayList<List<String>>();
    	List<String> list1=new ArrayList<String>();
    	list1.add("John");
    	list1.add("johnsmith@mail.com");
    	list1.add("johnsmith@mail.com");
    }
}
