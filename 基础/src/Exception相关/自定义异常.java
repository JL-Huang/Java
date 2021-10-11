package Exception相关;
//如果JDK没有解决我们的异常的方法，可以自定义异常类
//若继承自Exception类，则是受检查异常，编译器必须处理,trycatch或者throws
//若继承自RuntimeException,则为运行时异常，可以在运行出错再处理
//习惯上自定义异常要有两个构造器，一个默认，一个带有详细信息
public class 自定义异常 {
public static void main(String[] args) throws Illegalsex {
	Person person=new Person();
	person.setAge(1);
	person.setSex("公");
}
}
class Person{
	int age;
	String sex;
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
//直接用语句抛出,注意是throw不是throws
		if(age<0) {
			throw new IllegalAge("太年轻了");
		}
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) throws Illegalsex {
		if(sex!="男" & sex!=" 女") {
			throw new Illegalsex("错了");
		}
		this.sex = sex;
	}
	
}


//这是RuntimeException
class IllegalAge extends RuntimeException{
	public IllegalAge() {
		// TODO Auto-generated constructor stub
	}
	IllegalAge(String msg){
	super(msg);
	}
}
//这是Exception
class Illegalsex extends Exception{
	public Illegalsex() {
		// TODO Auto-generated constructor stub
	}
//	这里不是很懂这个super写法,可能是其父类只有一个参数为String的方法吧
	public Illegalsex(String aaa) {
	super(aaa);
	}
}