package 常考;

public class 排序 {
	public static void main(String[] args) {
		int[] array= {6,3,6,7,2,1,0,5};
		排序 manySorts=new 排序();
		manySorts.quick(array, 0, array.length);
		for(int temp:array)
		System.out.print(temp);
	}
//	冒泡排序，稳定，平均时间复杂度O(n^2),最佳情况O(n)（需要改造一下代码）,空间复杂度O(1)
	public int[] bubble(int[] array) {
		int[] copy=array;
//		boolean flag=false;
		for(int i=0;i<copy.length-1;i++) {
//			从下标array.length-1到下标i+1,与其前一个比较，因为i前面肯定已经排好
//			flag=true;
//			注意冒泡的特点，左边向右冒，则右边先冒好，反之亦然
			for(int j=copy.length-1;j>i;j--) {
//				发现j比j-1小，马上交换
				if(copy[j]<copy[j-1]) {		
					int temp=copy[j];
					copy[j]=copy[j-1];
					copy[j-1]=temp;
//					flag=false;
				}
			}
//			if(flag) return array;
		}
		return copy;
	}
//	快速排序，不稳定
	public void quick(int[] array,int low,int high) {
		if(low>high) return;
		int left=low;
		int right=high;
//		左边第一个数为基准
		int key=array[low];
		while(left<right) {
//			找到左边起第一个比基准大的数的下标
			while(array[left]<key) left++;
//			找到右边起第一个比基准小的数的下标
			while(array[right]>key) right--;
//			交换这两个下标对应的数
			if(left<right) {
				int temp=array[left];
				array[left]=array[right];
				array[right]=temp;
			}
		}
//		交换left指针和左边第一个数（也就是基准）
		int temp=array[left];
		array[left]=array[low];
		array[low]=temp;
//		二分递归
		quick(array,low,left-1);
		quick(array,left+1,high);
	}
//	直接选择排序，不稳定，时间复杂度O(n^2)
	public int[] select(int[] array) {
		int[] copy=array;
		for(int i=0;i<copy.length-1;i++) {
//			确定了一个指针后，另一指针往右遍历找最大值
			for(int j=i+1;j<copy.length;j++) {
//				发现有数比外指针小，马上交换，确保外指针最小
				if(copy[i]>copy[j]) {
					int temp=copy[j];
					copy[j]=copy[i];
					copy[i]=temp;
				}
			}
		}
		return copy;
	}
//	堆排序.时间复杂度O(nlogn),空间复杂度O(1)
//	首先确认一点,以数组下标编号,父亲节点标号i,则左孩子标号2*i+1;右孩子2*i+2
	public int[] heap(int[] array) {
		int[] copy=array;
//		构建最大堆,从第一个非叶子节点开始,从底向上调整结构
//		因为具体步骤是由顶向下的，所以可以确保所有节点都是最大堆结构
		for(int i=copy.length/2-1;i>=0;i--) adjust(copy,i,array.length);
//		因为最大堆第一个元素一定是最大值，把它与j=length-1交换即可,然后调整结构，第一个元素又是最大值，给j--；
		for(int j=copy.length-1;j>0;j--) {
			int temp=copy[0];
			copy[0]=copy[j];
			copy[j]=temp;
//			沿着堆的父节点往下进行,复杂度为O(logn)
			adjust(copy,0,j);
		}
		return copy;
	}
//	构建最大堆具体调整步骤.要做的就是由当前节点往下将一个节点置换成其本身及左右节点中的最大值
	private void adjust(int[] array,int i,int length) {
//		从该元素左节点开始
		for(int k=2*i+1;k<length;k=2*k+1) {
//			如果左右节点中的较大值
			if(k<length-1&&array[k]<array[k+1]) k++;
//			如果子节点大于父节点,将两个节点交换,同时注意把下标也换了,因为要保证堆结构延续下去
			if(array[k]>array[i]) {
				int temp=array[i];
				array[i]=array[k];
				array[k]=temp;
				i=k;
			}else {
				break;
			}
		}
	}
//	直接插入排序，扫描一遍，每扫到一个元素，将其按大小插入到其之前的子列,类似于打扑克的抽卡
//	外指针是遍历要移动的元素，内指针是轮询已经排好的序列
//	选择与插入刚好是对应的，都是先排好子列，前者是右边子列找最小值与i交换，后者是i左边子列往左不断冒泡直到遇到比它小的数
//	平均时间复杂度O(n^2)，最好情况下O(n)，不需要重写代码
	public int[] insert(int[] array) {
		int[] copy=array;
		for(int i=0;i<copy.length;i++) {
			for(int j=i;j>0&&copy[j]<copy[j-1];j--) {
					int temp=copy[j];
					copy[j]=copy[j-1];
					copy[j-1]=temp;
			}
		}
		return copy;
		}
//	希尔排序，第一次跳N/2个排好，第二次跳N/4个排好，第二次跳着排序不影响第一次结果，以此类推
//	最坏情况为O(n^2),前面都没有交换,只有当gap=1才交换,退化为插入排序
	public int[] shell(int[] array) {
//		先确定gap的范围
		int[] copy=array;
		for(int gap=copy.length/2;gap>0;gap/=2) {
//			这个循环是选起点
			for(int i=0;i<copy.length;i++) {
//				这个循环做的是选好范围与起点后跳着排序
				for(int j=i;j-gap>=0&&copy[j]<copy[j-gap];j-=gap) {
						int temp=copy[j-gap];
						copy[j-gap]=copy[j];
						copy[j]=temp;
				}
			}
		}
		return copy;
	}


}
