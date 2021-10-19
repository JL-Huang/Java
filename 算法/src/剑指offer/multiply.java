package 剑指offer;
//给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
//不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
public class multiply {
//	B[0]：	1	A[1]	A[2]
//	B[1]：	A[0]	1	A[2]
//	B[2]：	A[0]	A[1]	1
//	分别算出上三角下三角相乘即可
    public int[] multiply(int[] A) {
    	int[] B=new int[A.length];
    	int[] downB=new int[A.length];
    	int[] upB=new int[A.length];
//    	这里算出下三角部分
    	downB[0]=1;
    	for(int i=1;i<A.length;i++)
    		downB[i]=downB[i-1]*A[i-1];
//    	这里算出上三角部分
    	upB[A.length-1]=1;
    	for(int i=A.length-2;i>=0;i--)
    		upB[i]=upB[i+1]*A[i+1];
//    	然后汇总，完成
    	for(int i=0;i<B.length;i++)
    		B[i]=downB[i]*upB[i];
    	return B;
    }
}
