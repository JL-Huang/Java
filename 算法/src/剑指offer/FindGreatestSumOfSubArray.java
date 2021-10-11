package 剑指offer;
//{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
//给一个数组，返回它的最大连续子序列
public class FindGreatestSumOfSubArray {
//	不会动态规划写出来的错误答案,思路是双指针,左边指针固定,右边指针不断右移直到找到当前左指针对应子数组和最大值,保存起来
//	事实上,这里做了很多重复或者不必要的运算与判断
//    public int test(int[] array) {
//        if(array.length==0) return 0;
//        int sum=Integer.MIN_VALUE;
//        for(int i=0;i<array.length;i++) {
//        	int maxtempsum=Integer.MIN_VALUE;
//        	for(int j=i;j<array.length;j++) {
//            	int tempsum=array[j];
//        		if(j!=array.length-1) {
//        			maxtempsum=tempsum<tempsum+array[j]?tempsum+array[j]:tempsum;
//        			tempsum+=array[j];
//        		}
//        	}
//        	sum=sum>maxtempsum?sum:maxtempsum;
//        }
//        return sum;
//    }
	public int test(int[] array) {
		if(array.length==0) return 0;
//		定义两个整数,tempmax保存每次最大序列和,max保存最终结果
		int tempmax=0;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<array.length;i++) {
//			这个判断十分关键,当出现tempmax<=0,那么前面必须丢弃,以最后元素作为tempmax了
//			因为如果不丢弃,那加上当前元素,只会比当前元素小
			if(tempmax<=0) tempmax=array[i];
//			直接把当前遍历到的数加上,不管正负,因为就算是负数,max已经记录好加上这个负数前的数据
//			而这时还应该继续往后探索,看看有没有大数使结果反转
			else tempmax+=array[i];
			max=max>tempmax?max:tempmax;	
		}
		return max;
	}
}
