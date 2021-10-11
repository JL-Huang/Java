package 剑指offer;
//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
public class FindNumsAppearOnce {
    public void test(int [] array,int num1[] , int num2[]) {
//    	边界情况
        if(array.length==2) {
        	num1[0]=array[0];
        	num2[0]=array[1];
        }
//        思路是将所有数异或，因为异或满足交换律，自己跟自己异或为0，与0异或为本身，所以最后结果一定是两个目标数异或的结果
        int xorreslt=0;
        for(int i=0;i<array.length;i++) xorreslt^=array[i];
//        然后是找到异或结果第一个1的下标，说明至少在这一位上两者是不同的
        int index=IndexOfOne(xorreslt);
//        然后遍历数组，判断下标这一位的情况，为1的所有数取异或，得出一个答案，为0的同样操作，得到另一个答案
        for(int i=0;i<array.length;i++) {
        	switch(OneorZero(array[i],index)) {
        	case 1:
        		num1[0]^=array[i];
        		break;
        	case 0:
        		num2[0]^=array[i];
        		break;   	
        	}
        }
        return;
    }
//    找第一个1出现的位置
//    方法是不断与1与，与完之后结果为0则原数右移，index++，直到与的结果为1，输出此时index
    public int IndexOfOne(int i) {
    	int index=0;
    	while((i&1)==0&&index<=32) {
    		i>>=1;
    		index++;
    	}
    	return index;
    }
//    知道index后，只需要将一个数右移index位与1与，就可以知道这一位是0还是1
    public int OneorZero(int i,int index) {
    	return (i>>index)&1;
    }
}
