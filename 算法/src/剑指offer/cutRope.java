package 剑指offer;
//给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],...,k[m]。
//请问k[1]x...xk[m]可能的最大乘积是多少？
//例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
public class cutRope {
//	思路很简单，4肯定分割成2*2，5肯定分割成2*3，6肯定分割成3*3而不是2*2*2，总之是分割出尽可能多的3
//	只有当余数为1，才把3*1换成2*2
    public int test(int target) {
    	if(target==2) return 1;
    	if(target==3) return 2;
    	if(target%3==0) return (int) Math.pow(3, target/3);
    	if(target%3==1) return (int) (4*Math.pow(3, target/3-1));
    	if(target%3==2) return (int) (2*Math.pow(3, target/3));
    	return 0;
    }
}
