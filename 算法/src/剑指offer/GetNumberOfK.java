package ��ָoffer;
//ͳ��һ�����������������г��ֵĴ�����
public class GetNumberOfK {
//	˼·�ǳ��򵥣��ؼ��Ǿ���ʵ��
//	��Ȼ��ʾ���������飬�Ǿ�һ���Ƕ��ַ�
//	���ַ���ֵ��ע����ǣ�start=endʱû��ѭ����start>end����
    public int test(int [] array , int k) {
    	if(array.length==0) return 0;
    	if((getlastk(array, 0, array.length-1, k)!=-1)&&(getfirstk(array, k)+1!=-1))
    	return getlastk(array, 0, array.length-1, k)-getfirstk(array, k)+1;
    	else return 0;
    }
//    ���ǵ���д��
//    ע�⣬��start=endʱ�����������forѭ������Ϊstart<=end
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
//    ���ǵݹ�д��
//    ͬ������ֹ�ݹ��������start>end�����ǵ���
//    ���ǵ��ڵ�������Ǿ���ֻʣһ�������Ǳ�Ȼ�Ƿ�������������Ƿ���-1
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