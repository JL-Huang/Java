package 以前的理解.Decorate;
//两个类实现同一个接口，一个类里面定义另一个类对象作为成员变量，并将其作为构造方法的参数
//然后在自己的接口方法里调用成员变量的接口方法，对其进行各种操作，整个过程就是装饰性模式
//1.抽象组件：需要装饰的抽象对象（接口或抽象父类）
//2.具体组件：需要装饰的对象
//3.抽象装饰类：包含了对抽象组件的引用以及修饰着共有的方法
//4.具体修饰类：被装饰的对象


//				实现接口，重写目标方法并返回自己属性
//抽象组件（接口）——————————————————————————————————具体组件（被装饰的类）
//		|
//		|
//		|
//		|实现接口，将接口对象作为成员变量并作为构造方法参数，重写目标方法返回该成员变量的目标方法			
//		|——————————————————————————————————————————————————————————————————————-————————————抽象装饰类
//																								|
//																								|
//				  继承抽象装饰类，自动重写构造方法，手动重写目标方法。返回super目标方法+自己的操作	|
//		具体修饰类————————————————————————————————————————————————————————————————————————————————

//具体引用时需要两个接口对象，一个用具体组件的构造方法，另一个用具体装饰类的构造方法，将前一个对象作为参数
//这样子的好处是整个过程被修饰的类及其目标方法并没有被改变，但通过装饰实现了拷贝，对拷贝的类和目标方法进行了变换

public class TryDecorate {
public static void main(String[] args) {
	Drink coffee=new Coffee();
	Drink sugarcoffee=new sugar(coffee);
	System.out.println(sugarcoffee.info()+sugarcoffee.cost());
	Drink tea=new Tea();
	Drink milktea=new milk(tea);
	System.out.println(milktea.info()+milktea.cost());
}
}
//抽象组件,抽象组件一般是一个接口，里面的方法是目标方法，是整个过程操作的对象
interface Drink{
	Double cost();
	String info();
}
//具体组件，具体组件可以有多个，但共同之处都在于实现类接口的方法并且返回的是自己的属性
class Coffee implements Drink{
	private String name="原味咖啡"; 
	private Double price=(double) 10;
	@Override
	public Double cost() {
		return price;
	}

	@Override
	public String info() {
		return name;
	}
	
}
class Tea implements Drink{
	private String name="茶"; 
	private Double price=(double) 20;
	@Override
	public Double cost() {
		return price;
	}

	@Override
	public String info() {
		return name;
	}
	
}
//抽象装饰类，装饰模式的核心枢纽，它是一个实现了接口的抽象类，在抽象装饰类里声明了一个接口对象
//在其构造方法里加入了接口对象，然后又重写接口方法，实现了抽象组件（接口）到修饰类（抽象+具体）的连接
abstract class Decorate implements Drink{
	private Drink drink;
	
//		重载构造方法，形参加入抽象组件对象
	public Decorate(Drink drink) {
		super();
		this.drink = drink;
	}

	@Override
	public Double cost() {
		return this.drink.cost();
	}

	@Override
	public String info() {
		return this.drink.info();
	}
	
}

//具体修饰类（被装饰对象+装饰内容）
//引用被装饰对象不是通过直接引用，而是通过继承抽象装饰类
//具体装饰类继承了抽象装饰类，就可以间接引用装饰对象了
//java规定若父类重载了构造方法，则子类必须重写自身构造方法，使形参和返回值与父类重载后的构造方法一样
class milk extends Decorate{

	public milk(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double cost() {
		// TODO Auto-generated method stub
		return super.cost()*4;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"加入了牛奶";
	}	
}

class sugar extends Decorate{

	public sugar(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double cost() {
		// TODO Auto-generated method stub
		return super.cost()*3;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"加入了糖";
	}
	
	
}