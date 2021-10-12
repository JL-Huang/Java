package 以前的理解.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//动态代理模式，自动生成代理类，不用像静态代理那样手动创建
//Proxy.newProxyInstance返回的是第二个参数的实例对象
//调用proxy的任何接口方法，都会触发handle被重写的invoke方法
//method.invoke(star_1, args)表示调用star_1中的该method，如果换成其他Star的实现类对象则是实现其他实现类对象的sign方法
//所以可以把需要复用的方法扔重写invoke里面
//更万能的是.可以把StarHandler的参数类型改成Object.然后由调用方进行强转,这样的话一个代理类可以代理所有类

//两个要素：
//InvocationHandler实现类，是一个接口增强类，构造方法参数是需要实现的接口，需要实现invoke方法，可以添加一些增强的方法
//proxy对象，调用Proxy的newProxyInstance静态方法获得，将handle作为，利用反射获得接口对象
//proxy对象就可以直接代理
public class DynamicProxy {
	public static void main(String[] args) {
		Star star_1=new RealStar();
		StarHandler handler=new StarHandler(star_1);
		//这行可以写到StarHandler里面
		Star proxy=(Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {Star.class}, handler);
		proxy.sign();
	}

}
class StarHandler implements InvocationHandler{
	private Star star_1;
	public StarHandler(Star star_1) {
		super();
		this.star_1 = star_1;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		method.invoke(star_1, args);
		return null;
	}
	
}
interface Star{
	void sign();
}
class RealStar implements Star{

	@Override
	public void sign() {
		// TODO Auto-generated method stub
		System.out.println("孙悟空");
	}
	
}