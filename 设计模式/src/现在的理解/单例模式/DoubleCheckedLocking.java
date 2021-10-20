package 现在的理解.单例模式;
//单例模式：对外只存在一个对象
//1.构造器私有化->避免外部new构造器
//2.提供私有的静态属性->存放对象的地址
//3.提供公共的静态方法->获取属性
public class DoubleCheckedLocking {
//	没有在新建引用时实例化，就叫懒汉模式
//	双重检验锁，双重指的是两次判本类静态属性是否为空，一次是防止多线程重复创建，一次是防止不必要的非空判断等待
	//1.构造器私有化->避免外部new构造器
	private DoubleCheckedLocking() {
	}
	//2.提供私有的静态属性->存放对象的地址
	private static volatile DoubleCheckedLocking instance;
	//3.提供公共的静态方法->获取属性
	public static DoubleCheckedLocking getinstance() {
//		加个若不为空直接读取，是防止其他线程等待前面的线程进行锁里面的判断
		if(instance!=null) {
			return instance;
		}
//		加个非空判断,加个锁，注意这里也可以锁instance的，因为instance是静态变量，Class类对象只有一个instance
			synchronized (DoubleCheckedLocking.class) {
				
				if(instance==null) {
//		这里有可能发生指令重排，本来是开辟对象空间-初始化对象信息-将对象地址给引用的顺序，多线程情况下可能重排
//		本来是先执行instance的写再执行instance的读，所以给instance加个volatile
					instance=new DoubleCheckedLocking();
				}
			}
		return instance;
	}

	public static void main(String[] args) {
//		可以看到这里产生的对象地址一样
		Thread t1=new Thread(()-> {
			System.out.println(DoubleCheckedLocking.getinstance());
		});
		t1.start();
		System.out.println(DoubleCheckedLocking.getinstance());
	}
}
