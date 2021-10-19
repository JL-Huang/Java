package 剑指offer;
//统计一个数字在排序数组中出现的次数。
public class GetNumberOfK {
//	思路非常简单，关键是具体实现
//	既然提示了排序数组，那就一定是二分法
//	二分法最值得注意的是，start=end时没有循环，start>end才是
    public int test(int [] array , int k) {
    	if(array.length==0) return 0;
    	if((getlastk(array, 0, array.length-1, k)!=-1)&&(getfirstk(array, k)+1!=-1))
    	return getlastk(array, 0, array.length-1, k)-getfirstk(array, k)+1;
    	else return 0;
    }
//    这是迭代写法
//    注意，当start=end时出结果，所以for循环条件为start<=end
    public int getfirstk(int [] array , int k) {
    	 for(int start=0,end=array.length-1,middle=(end+start)/2;start<=end;middle=(end+start)/2) {
    	     if(start>end) return -1;
    		 if(k>array[middle]) start=middle+1;
    		 if(k<array[middle]) end=middle-1;
    		 if(k==array[middle]) {
    			 while(middle-1>=0&&k==array[middle-1]) middle--;
    			 return middle;
    		 }
    	 }
    	 return -1;
    }
//    这是递归写法
//    同样，终止递归的条件是start>end，不是等于
//    考虑等于的情况，那就是只剩一个数，那必然是返回这个数而不是返回-1
    public int getlastk(int [] array,int start,int end,int k) {
    	if(start>end) return -1;
    	int middle=(end+start)/2;
    	if(k>array[middle]) return getlastk(array,middle+1,end,k);
    	if(k<array[middle]) return getlastk(array,start,middle-1,k);
		if(k==array[middle]) {
			 while(middle+1<array.length&&k==array[middle+1]) middle++;
			 return middle;
		 }
		return -1;
    }
}
