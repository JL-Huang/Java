package 常考;

public class 单例 {
private volatile static 单例 instance;
private 单例() {}
public static 单例 getInstance() {
//	公开的方法里面先进行第一次非空判断，这是为了减少开销，因为加锁开销很大
	if(instance==null) {
		synchronized (单例.class) {
//			这个非空判断是保证单例
			if(instance==null)
//				volatile是防止这里的指令重排
//				1.开辟空间2.创建对象3.指向实例化对象内存地址
//				若指令重排132，则上面两个非空判断都会被冲破
//				另一个线程直接返回一个没有实例化的instance
				instance=new 单例();
		}
	}
	return instance;
}
}
