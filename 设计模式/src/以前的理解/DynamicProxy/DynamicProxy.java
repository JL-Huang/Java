package ��ǰ�����.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//��̬����ģʽ���Զ����ɴ����࣬������̬���������ֶ�����
//Proxy.newProxyInstance���ص��ǵڶ���������ʵ������
//����proxy���κνӿڷ��������ᴥ��handle����д��invoke����
//method.invoke(star_1, args)��ʾ����star_1�еĸ�method�������������Star��ʵ�����������ʵ������ʵ��������sign����
//���Կ��԰���Ҫ���õķ�������дinvoke����
//�����ܵ���.���԰�StarHandler�Ĳ������͸ĳ�Object.Ȼ���ɵ��÷�����ǿת,�����Ļ�һ����������Դ���������

//����Ҫ�أ�
//InvocationHandlerʵ���࣬��һ���ӿ���ǿ�࣬���췽����������Ҫʵ�ֵĽӿڣ���Ҫʵ��invoke�������������һЩ��ǿ�ķ���
//proxy���󣬵���Proxy��newProxyInstance��̬������ã���handle��Ϊ�����÷����ýӿڶ���
//proxy����Ϳ���ֱ�Ӵ���
public class DynamicProxy {
	public static void main(String[] args) {
		Star star_1=new RealStar();
		StarHandler handler=new StarHandler(star_1);
		//���п���д��StarHandler����
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
		System.out.println("�����");
	}
	
}