package Fight;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GenSheiXue1 {


/*������������������ʵ����ĿҪ��Ĺ���
��Ȼ����Ҳ���Բ������������ģ����������ȫ�����Լ����뷨�� ^-^ 
******************************��ʼд����******************************/
    static List<List<String>> mergeAccount(List<List<String>> accounts) {
        // �ڴ˴���дʵ�ִ����߼�
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
/******************************����д����******************************/


    public static void main(String[] args) {
    	List<List<String>> accounts=new ArrayList<List<String>>();
    	List<String> list1=new ArrayList<String>();
    	list1.add("John");
    	list1.add("johnsmith@mail.com");
    	list1.add("johnsmith@mail.com");
    }
}
