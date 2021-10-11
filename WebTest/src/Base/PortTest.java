package Base;
//Socket套接字，套接字地址指IP地址加端口号或主机地址加端口号
//端口是传输层的概念，UDP与TCP同一协议下的端口不能重复
//这个类同样没有构造方法
import java.net.InetSocketAddress;

public class PortTest {
public static void main(String[] args) {
	 InetSocketAddress isa1=new InetSocketAddress("127.0.0.1",8888);
//	 获取当前Socket地址端口号
	 System.out.println(isa1.getPort());
	 InetSocketAddress isa2=new InetSocketAddress("localhost",9999);
	 
}
}
