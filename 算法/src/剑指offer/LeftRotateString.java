package ��ָoffer;
//�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
public class LeftRotateString {
    public String test(String str,int n) {
    	if(str.equals("")) return "";
        n=n%str.length();
        String longstr=str+str;
        return longstr.substring(n,str.length()+n);
    }
}
