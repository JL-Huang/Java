package 剑指offer;
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
//使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
public class ReOrderArray {
    public void test1(int [] array) {
        for(int i=0;i<array.length-1;i++) {
//        	这里相当于冒泡，遇到前偶后奇的，就交换，将偶数往后冒
        	for(int j=0;j<array.length-1-i;j++) {
        		if(array[j]%2==0&&array[j+1]%2==1) {
        			int temp=array[j];
        			array[j]=array[j+1];
        			array[j+1]=temp;
        		}
        	}
        }
    }
    public void test2(int [] array) {
        for(int i=0;i<array.length-1;i++) {
//        	这里相当于冒泡，遇到前偶后奇的，就交换，将偶数往后冒
        	for(int j=array.length-1;j>i;j--) {
        		if(array[j]%2==1&&array[j-1]%2==0) {
        			int temp=array[j];
        			array[j]=array[j-1];
        			array[j-1]=temp;
        		}
        	}
        }
    }
}
