package Generic相关;
//泛型
public class 泛型 {
public static void main(String[] args) {
	Testnogeneric tng=new Testnogeneric();
//	子类强转父类,所以虽然Testnogeneric中第一个参数是Object类,但可以直接赋字符串值
	tng.set("eer", 0);
//	这里可以看到,返回的是Object类型,必须强转才能变成子类String
	String str1=(String) tng.get(0);
	Testgeneric<String> tg=new Testgeneric();
	tg.set("数字",1 );
	tg.get(1);
	System.out.println(tg.objectlist[1]);
//	报错,因为已经上面已经锁定tg.set方法第一个参数为String
//	tg.set(123, 2);
}
}
class Testnogeneric{
	Object[] objlist=new Object[5];
	public void set(Object o,int index) {
		objlist[index]=o;
	}
	public Object get(int index) {
		return objlist[index];
	}
}
//泛型的形参一般为TEV三个字母,加在类之后
class Testgeneric<E>{
	Object[] objectlist=new Object[5];
	public void set(E e,int index) {
		objectlist[index]=e;
	}
	@SuppressWarnings("unchecked")
	public E get(int index) {
//		泛型也是需要强转的,但是可以在这里强转,不需要调用时再强转
		return (E) objectlist[index];
	}
}