package DeepList;


import java.util.Arrays;

//��дArrayList
//ArrayList���ڲ��ң�LinkList������ɾ��
//˳��˵һ��Vector������ArrayLiatһ���ײ������飬�������̰߳�ȫ�ģ���ζ��Ч�ʵ�
public class ��дArrayList {
public static void main(String[] args) {
	MyArrayList<String> myArrayList=new MyArrayList();
// ������Ը�������ⷺ�ͣ���Ȼ�������������˷���String��������add������û����������ͣ�������Ȼ������������
//	myArrayList.add(2);
//	myArrayList.add("duhada");
//	System.out.println(myArrayList);
	for(int i=0;i<50;i++) {
		myArrayList.add(i);
	}
	System.out.println(myArrayList);
	MyArrayList<Integer> list2=new MyArrayList();
	list2.add(1);
	list2.add(3);
//	�����漰һ�����⣬��ΰ�һ���Զ������Ԫ����������
	Integer[] ii=new Integer[2];
	ii[0]=1;
	ii[1]=2;
//	ע��������ܶ�myArraylist���ò���ΪInteger���͵ķ�������Ϊ��ͬ����
	list2.remove(ii);
	System.out.println(list2);
	
}
}
class MyArrayList<E>{
//	size������ʱ�ĸ�����������ʾ����ĩλ�±�
	 private int size;
//	 elementData��ArrayList��ʵ������
	 private Object[] elementData;
//	 ���ø����޲ι��췽��ʱ���ɵ�Ĭ�����鳤��
	 private static final int DEFAULT_LENGTH=10;
	 public MyArrayList(){
		 elementData=new Object[DEFAULT_LENGTH];
		}
	 public MyArrayList(int length) {
		 elementData=new Object[length];
	 }
	 public void add(Object o) {
		 if(size==elementData.length) {
//			 �������ݣ����Ƽ�һ�룬ע��Ҫ���ţ���Ϊ�����ȼ�����>>
		 Object[] newobject=new Object[elementData.length+(elementData.length>>1)];
		 System.arraycopy(elementData, 0, newobject, 0, elementData.length);
		 elementData=newobject;
		 elementData[size++]=o;
		 }else {
			 elementData[size++]=o;
		 }
	 }
	 public Object get(int index) {
		return elementData[index];
		 
	 }
	 public void remove(E[] ii) {
		 for(int i=0;i<elementData.length;i++) {
			 for(int j=0;j<ii.length;j++) {
				 if(elementData[i]==ii[j]) {
					 System.arraycopy(elementData,i+1, elementData, i, elementData.length-i-1);
				 }
			 }
		 }

	 }
//	 public void add(Object o,int index) {
//		 elementData[index]=o;
//	 }
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<size;i++) {
			sb.append(elementData[i]);
		}
//		ע��ϵͳĬ�ϵ�toString����ֻ�����Եذ��������ݴ�ӡ����
		return sb.toString();

	}
	 
}