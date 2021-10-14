package ����;

public class ���� {
	public static void main(String[] args) {
		int[] array= {6,3,6,7,2,1,0,5};
		���� manySorts=new ����();
		manySorts.quick(array, 0, array.length);
		for(int temp:array)
		System.out.print(temp);
	}
//	ð�������ȶ���ƽ��ʱ�临�Ӷ�O(n^2),������O(n)����Ҫ����һ�´��룩,�ռ临�Ӷ�O(1)
	public int[] bubble(int[] array) {
		int[] copy=array;
//		boolean flag=false;
		for(int i=0;i<copy.length-1;i++) {
//			���±�array.length-1���±�i+1,����ǰһ���Ƚϣ���Ϊiǰ��϶��Ѿ��ź�
//			flag=true;
//			ע��ð�ݵ��ص㣬�������ð�����ұ���ð�ã���֮��Ȼ
			for(int j=copy.length-1;j>i;j--) {
//				����j��j-1С�����Ͻ���
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
//	�������򣬲��ȶ�
	public void quick(int[] array,int low,int high) {
		if(low>high) return;
		int left=low;
		int right=high;
//		��ߵ�һ����Ϊ��׼
		int key=array[low];
		while(left<right) {
//			�ҵ�������һ���Ȼ�׼��������±�
			while(array[left]<key) left++;
//			�ҵ��ұ����һ���Ȼ�׼С�������±�
			while(array[right]>key) right--;
//			�����������±��Ӧ����
			if(left<right) {
				int temp=array[left];
				array[left]=array[right];
				array[right]=temp;
			}
		}
//		����leftָ�����ߵ�һ������Ҳ���ǻ�׼��
		int temp=array[left];
		array[left]=array[low];
		array[low]=temp;
//		���ֵݹ�
		quick(array,low,left-1);
		quick(array,left+1,high);
	}
//	ֱ��ѡ�����򣬲��ȶ���ʱ�临�Ӷ�O(n^2)
	public int[] select(int[] array) {
		int[] copy=array;
		for(int i=0;i<copy.length-1;i++) {
//			ȷ����һ��ָ�����һָ�����ұ��������ֵ
			for(int j=i+1;j<copy.length;j++) {
//				������������ָ��С�����Ͻ�����ȷ����ָ����С
				if(copy[i]>copy[j]) {
					int temp=copy[j];
					copy[j]=copy[i];
					copy[i]=temp;
				}
			}
		}
		return copy;
	}
//	������.ʱ�临�Ӷ�O(nlogn),�ռ临�Ӷ�O(1)
//	����ȷ��һ��,�������±���,���׽ڵ���i,�����ӱ��2*i+1;�Һ���2*i+2
	public int[] heap(int[] array) {
		int[] copy=array;
//		��������,�ӵ�һ����Ҷ�ӽڵ㿪ʼ,�ӵ����ϵ����ṹ
//		��Ϊ���岽�����ɶ����µģ����Կ���ȷ�����нڵ㶼�����ѽṹ
		for(int i=copy.length/2-1;i>=0;i--) adjust(copy,i,array.length);
//		��Ϊ���ѵ�һ��Ԫ��һ�������ֵ��������j=length-1��������,Ȼ������ṹ����һ��Ԫ���������ֵ����j--��
		for(int j=copy.length-1;j>0;j--) {
			int temp=copy[0];
			copy[0]=copy[j];
			copy[j]=temp;
//			���Ŷѵĸ��ڵ����½���,���Ӷ�ΪO(logn)
			adjust(copy,0,j);
		}
		return copy;
	}
//	�������Ѿ����������.Ҫ���ľ����ɵ�ǰ�ڵ����½�һ���ڵ��û����䱾�����ҽڵ��е����ֵ
	private void adjust(int[] array,int i,int length) {
//		�Ӹ�Ԫ����ڵ㿪ʼ
		for(int k=2*i+1;k<length;k=2*k+1) {
//			������ҽڵ��еĽϴ�ֵ
			if(k<length-1&&array[k]<array[k+1]) k++;
//			����ӽڵ���ڸ��ڵ�,�������ڵ㽻��,ͬʱע����±�Ҳ����,��ΪҪ��֤�ѽṹ������ȥ
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
//	ֱ�Ӳ�������ɨ��һ�飬ÿɨ��һ��Ԫ�أ����䰴��С���뵽��֮ǰ������,�����ڴ��˿˵ĳ鿨
//	��ָ���Ǳ���Ҫ�ƶ���Ԫ�أ���ָ������ѯ�Ѿ��źõ�����
//	ѡ�������պ��Ƕ�Ӧ�ģ��������ź����У�ǰ�����ұ���������Сֵ��i������������i����������󲻶�ð��ֱ����������С����
//	ƽ��ʱ�临�Ӷ�O(n^2)����������O(n)������Ҫ��д����
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
//	ϣ�����򣬵�һ����N/2���źã��ڶ�����N/4���źã��ڶ�����������Ӱ���һ�ν�����Դ�����
//	����ΪO(n^2),ǰ�涼û�н���,ֻ�е�gap=1�Ž���,�˻�Ϊ��������
	public int[] shell(int[] array) {
//		��ȷ��gap�ķ�Χ
		int[] copy=array;
		for(int gap=copy.length/2;gap>0;gap/=2) {
//			���ѭ����ѡ���
			for(int i=0;i<copy.length;i++) {
//				���ѭ��������ѡ�÷�Χ��������������
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
