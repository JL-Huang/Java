package ��ָoffer;
//����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
//����������Yes,�������No���������������������������ֶ�������ͬ��
public class VerifySquenceOfBST {
	public static void main(String[] args) {
		int[] sequence= {4,8,6,12,16,14,10};
		System.out.println(new VerifySquenceOfBST().test(sequence));
	}
	boolean flag=true;
//	�ж�һ�������Ƿ��Ǻ������
//	���������еĹ������һ����һ���Ǹ��ڵ㣬����ԭ���鲻�䣬��ȡ��Χ�ݹ��ж�
//	�Լ�д��ʱ������ֱ�ӽ�ȡ���飬��������ĸ��Ʒǳ��鷳�������
//	��ȡ��Χ�Ļ�����ֹ�ݹ���������ȡ����������ͬ
//	ע����������ֱ�Ӿ����±�
	public boolean judge(int [] sequence,int left,int right) {
//		if(sequence==null) return true;
//		if(sequence.length==0) return true;
//		int root=sequence[sequence.length-1];����
		if(left>right) return true;
		int root=sequence[right];
		int i=left;
//		����һ��������i�Ѿ�������������
		for(;sequence[i]<root;i++) {}	
//		����ֱ�Ӿ���i����i+1
		for(int j=i;j<right;j++) {if(sequence[j]<root) return false;}	
		return judge(sequence, left, i-1)&&judge(sequence, i, right-1);
	}
    public boolean test(int [] sequence) {
        if(sequence==null) return false;
        if(sequence.length==0) return false;
        return judge(sequence, 0, sequence.length-1);
    }
}
