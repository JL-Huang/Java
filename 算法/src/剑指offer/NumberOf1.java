package 剑指offer;

//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
public class NumberOf1 {
//	一个二进制数与其减一后相与，会把由低位到高位数起第一个1置零
	public int test(int n) {
		int result=0;
		while(n!=0) {
			result++;
			n=n&(n-1);
		}
		return result;
	}
}
