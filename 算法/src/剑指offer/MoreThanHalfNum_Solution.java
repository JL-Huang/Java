package 剑指offer;
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
//由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
//如果不存在则输出0。
public class MoreThanHalfNum_Solution {
    public int test(int [] array) {
        int temp=0;
        int count=0;
//        摩尔投票法，第一个数count为1，之后每遍历，遇到不同的，count--，当count减到0，则用当前遍历到的数替换
        for(int i=0;i<array.length;i++){
            if(count==0) temp=array[i];
            if(array[i]==temp) count++;
            else count--;
        }
//        已知temp为出现最多的，接下来只需要判断出现次数
        int count1=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==temp) count1++;
        }
        return count1>array.length/2?temp:0;
    }
}
