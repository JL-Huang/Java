package 剑指offer;
//写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
public class Add {
//	这里考察的显然是位运算，涉及到了位运算的加法
//	位运算的加法主要有两步，一是异或（二进制中的加法），二是相与然后左移，得到进位，再与前面异或结果相加
//	相加过程又要重复上面两步，直到进位全部为零
//	显然，可以递归得出结果
    public int test(int num1,int num2) {
    	if(num2==0) return num1;
        int a=num1^num2;
        int b=(num1&num2)<<1;
        return test(a,b);
    }
}
