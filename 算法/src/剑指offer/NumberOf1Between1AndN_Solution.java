package ��ָoffer;
//�������Ǹ�����������1���ֵĴ�������1 �� n ��1���ֵĴ�����
public class NumberOf1Between1AndN_Solution {
    public int test(int n) {
    	int result=0;
        while(n>0) {
        	String str=String.valueOf(n);
        	char[] chars=str.toCharArray();
        	for(int i=0;i<chars.length;i++) {
        		if(chars[i]=='1') result++;
        	}
        	n--;
        }
        return result;
    }
}
