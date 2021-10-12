package ��ָoffer;
//����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]��
//����ʹ�ó�������ע�⣺�涨B[0] = A[1] * A[2] * ... * A[n-1]��B[n-1] = A[0] * A[1] * ... * A[n-2];��
public class multiply {
//	B[0]��	1	A[1]	A[2]
//	B[1]��	A[0]	1	A[2]
//	B[2]��	A[0]	A[1]	1
//	�ֱ������������������˼���
    public int[] multiply(int[] A) {
    	int[] B=new int[A.length];
    	int[] downB=new int[A.length];
    	int[] upB=new int[A.length];
//    	������������ǲ���
    	downB[0]=1;
    	for(int i=1;i<A.length;i++)
    		downB[i]=downB[i-1]*A[i-1];
//    	������������ǲ���
    	upB[A.length-1]=1;
    	for(int i=A.length-2;i>=0;i--)
    		upB[i]=upB[i+1]*A[i+1];
//    	Ȼ����ܣ����
    	for(int i=0;i<B.length;i++)
    		B[i]=downB[i]*upB[i];
    	return B;
    }
}
