package 剑指offer;
//字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
public class LeftRotateString {
    public String test(String str,int n) {
    	if(str.equals("")) return "";
        n=n%str.length();
        String longstr=str+str;
        return longstr.substring(n,str.length()+n);
    }
}
