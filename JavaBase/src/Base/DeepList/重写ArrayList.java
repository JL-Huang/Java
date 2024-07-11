package Base.DeepList;


//重写ArrayList
//ArrayList用于查找，LinkList用于增删改
//顺便说一下Vector，它与ArrayLiat一样底层是数组，但它是线程安全的，意味着效率低
public class 重写ArrayList {
public static void main(String[] args) {
	MyArrayList<String> myArrayList=new MyArrayList();
// 这里可以更深入理解泛型，虽然我在类里声明了泛型String，但是在add方法里没有用这个泛型，所以任然可以任意类型
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
//	这里涉及一个问题，如何把一个自定义类的元素做成数组
	Integer[] ii=new Integer[2];
	ii[0]=1;
	ii[1]=2;
//	注意这里，不能对myArraylist调用参数为Integer类型的方法，因为不同泛型
	list2.remove(ii);
	System.out.println(list2);
	
}
}
class MyArrayList<E>{
//	size是扩容时的辅助参数，表示数组末位下标
	 private int size;
//	 elementData是ArrayList的实质容器
	 private Object[] elementData;
//	 调用该类无参构造方法时生成的默认数组长度
	 private static final int DEFAULT_LENGTH=10;
	 public MyArrayList(){
		 elementData=new Object[DEFAULT_LENGTH];
		}
	 public MyArrayList(int length) {
		 elementData=new Object[length];
	 }
	 public void add(Object o) {
		 if(size==elementData.length) {
//			 数组扩容，右移加一半，注意要括号，因为＋优先级大于>>
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
//		注意系统默认的toString方法只是无脑地把数组内容打印出来
		return sb.toString();

	}
	 
}
