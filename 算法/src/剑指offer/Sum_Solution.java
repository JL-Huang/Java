package 剑指offer;
//求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//其实就是考察&&短路特性，短路之后不执行，相当于判断语句
public class Sum_Solution {
	public static void main(String[] args) {
		System.out.println(new Sum_Solution().test(10));
	}
    public int test(int n) {
    	boolean flag=(n>0)&&((n+=test(n-1))>0);
        return n;
    }
}
