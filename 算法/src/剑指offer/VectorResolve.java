package 剑指offer;
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
//NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
public class VectorResolve {
//	算法思路非常简单，看图就能理解，不断收缩找到突变为递减的点
//			/|
//		   / |
//		     |
//		     |/
//当然，时间复杂度度非常高
//    public int minNumberInRotateArray(int [] array) {
//        int low=0;
//        int high=array.length-1;
//        int mid=(low+high)/2;
//        while(array[low]<array[high]) {
//        	if(array[mid]<array[high]) high=mid-1;
//        	if(array[mid]==array[high]) high=high-1;
//        	if(array[mid]>array[high]) low=mid+1;
//        }
//        return array[low];
//    }
	
//	下面是比较巧妙的做法，只需要一次遍历
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0) return 0;
        if(array.length==1) return array[0];
        for(int i=0;i<array.length-1;i++) {
        	if(array[i]>array[i+1]) return array[i+1];
        }
        return 0;
    }
}
