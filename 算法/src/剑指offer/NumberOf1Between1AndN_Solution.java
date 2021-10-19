package 剑指offer;
//求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
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
