package ��ָoffer;

//����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ
public class NumberOf1 {
//	һ���������������һ�����룬����ɵ�λ����λ�����һ��1����
	public int test(int n) {
		int result=0;
		while(n!=0) {
			result++;
			n=n&(n-1);
		}
		return result;
	}
}
