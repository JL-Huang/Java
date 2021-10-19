package Base;

public class p6 {
	int i;
	String s;
	public p6(int i,String s) {
		this.i=i;
		this.s=s;
	}
	public static void main(String[] args) {
		p6 p=new p6(1,"2");//新建了一个p6对象p
		p.h1(p);//把实参p传给了h1方法的形参p，对对象p执行h1方法.事实上这里把h1设为静态更合适，只是演示需要
		System.out.println(p.s);
		//输出结果为3，说明h1方法确实改变了对象p的值
		p.h2(p);//把实参p传给了h2方法的形参p
		System.out.println(p.s);
		//输出结果为3，即h2并没有改变对象p的值
		//这是因为参数的传递是地址传递，形参地址得到了实参地址，如果对形参进行操作，就能将操作由地址返回实参
		//像h2一样，形参一开始获得了实参的地址，但随即形参获得了另一新建对象的地址，此时对形参操作结果就不能返回实参了
	}
	public void h1(p6 p) {
		p.s="3";//这里p是类为p6的形参
	}
	public void h2(p6 p) {
		p=new p6(4,"5");
	}
}
