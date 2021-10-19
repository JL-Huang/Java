package Base;

public class p8 {
	public static void main(String[] args) {
		son k=new son();
		//这里可以不用对象直接调用构造方法，因为构造方法没有返回值
		//在执行构造方法的时候，也执行了父类的构造方法,即使是省略了super();
		
	}
}
class father {
	//构造方法可以不用写返回值类型
	public  father(){
		System.out.println("father");
		
	}
}
class son extends father{
	int i;
	public son() {
		//super();
		System.out.println("son");
		this.i=1;
		
	}
}
