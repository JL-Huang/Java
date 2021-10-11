package File相关;
//枚举

public class 枚举 {
public static void main(String[] args) {
//	可以调用枚举类产生一个对象，但是该对象只能定义为该枚举类中的常量
	Season a=Season.夏天;
	switch(a) {
	case FALL:
	System.out.println("吃果子");
	break;
	case 夏天:
	System.out.println("游泳");
	break;
	}
}
}
//枚举地位相当于一个类，所以必须在类以外定义
//它定义了一系列常量
enum Season{
	 春天,夏天,FALL,WINTER
}
