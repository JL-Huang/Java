 package 剑指offer;
//N个人围成一圈，编号0到n-1，给出m，第一个人从0开始报数，报m-1的将被杀掉
//下一个人接着从0开始报。如此反复，最后剩下一个，求最后的胜利者编号。
public class LastRemaining_Solution {
	public static void main(String[] args) {
		System.out.println(new LastRemaining_Solution().test(5,3));
	}
//	约瑟夫环问题
//	第一次的人被杀后，下一个人开始报数，下一轮大家报的数是(x-m)%num,x是大家前一轮报的数,num是前一轮的人数
//	其实就是一轮过后，全部人下标减去了m，因为是循环的，所以取模，即使m比人数还大，也不过是多循环了几次
//	有x(before)=(x(after)+m)%num，num是前一轮的人数
//	最后的幸存者报的数肯定是0
    public int test(int n, int m) {
//    	龙鸣边界，为了边界而边界
    	if(n==0||m==0) return -1;
//    	最后一轮，报数0，人数1
    	int x=0,num=1;
//    	循环内算出的是上一轮的结果，所以算到n-1就停止，跳出了
//    	首先人数++，算出上一轮的人数，然后套用上面的公式
        while(num<n) x=(x+m)%++num;
         return x;
    }
}
