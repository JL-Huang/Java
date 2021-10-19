package 秋招;

import java.util.Scanner;

public class XiaoMi1 {
    static String reverse(String sourceStr, String changeStr) {
    	String[] split_result=sourceStr.split(changeStr);
    	String reverse_element="";
    	for(int i=0;i<changeStr.length();i++) {
    		reverse_element+=changeStr.charAt(changeStr.length()-1-i);
    	}
    	StringBuilder sb=new StringBuilder();
    	for(int i=0;i<split_result.length;i++) {
    		sb.append(split_result[i]);
    		sb.append(reverse_element);
    	}
    	if(sb.length()>=sourceStr.length())
    	sb.delete(sb.length()-reverse_element.length(), sb.length());
    	return sb.toString();
    }


    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	String i1=sc.nextLine();
    	String sourceStr=i1.substring(1, i1.length()-1);
    	String i2=sc.nextLine();
    	String changeStr=i2.substring(1, i2.length()-1);
		System.out.println("\""+reverse(sourceStr, changeStr)+"\"");
	}
}
