package Base.Base1;

public class p5 {
	public int i;
	public String s;
	public static String ss;
	//静态初始化块，用于静态变量的初始化，不能调用非静态变量与方法，但可以调用静态方法
	//先输出5，说明是先加载类，伴随着静态变量的初始化，然后再执行构造方法
	static {
		ss="5";
		hhh();
	}
	//构造方法不同与一般的方法，既有静态的特性可以被静态方法调用，又有非静态属性可以在构造方法内部用this关键字
	public p5(int i,String s,String ss) {
		this.i=i;
		this.s=s;
		this.ss=ss;
	}
	public static void main(String[] args) {
		p5 p=new p5(1,"2","3");
		p5.hhh();//结果为3，说明在调用构造方法会改变静态变量，p5类中静态变量ss的值已经被改变
		p5.ss="4";//这里看到，静态变量的赋值是通过类+静态变量的方法
		hhh();//输出为4，说明静态方法调用静态变量
	}
	public static void hhh(){
		System.out.println(ss);
	}
}
