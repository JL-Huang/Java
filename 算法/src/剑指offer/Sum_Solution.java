package ��ָoffer;
//��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
//��ʵ���ǿ���&&��·���ԣ���·֮��ִ�У��൱���ж����
public class Sum_Solution {
	public static void main(String[] args) {
		System.out.println(new Sum_Solution().test(10));
	}
    public int test(int n) {
    	boolean flag=(n>0)&&((n+=test(n-1))>0);
        return n;
    }
}
