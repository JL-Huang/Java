package Base;
//InetAdress类代表一个IP地址，封装了很多信息
//这个类没有构造方法，只有静态方法返回
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetTest {
public static void main(String[] args) throws UnknownHostException {
//	静态方法，返回本机的主机地址
	InetAddress ip=InetAddress.getLocalHost();
	System.out.println(ip);
	System.out.println(ip.getHostAddress());
	System.out.println(ip.hashCode());
//	根据域名获得ip对象
	InetAddress ip1=InetAddress.getByName("www.baidu.com");
	System.out.println(ip1.getHostName());//域名
	System.out.println(ip1.getHostAddress());//该域名ip地址
//	根据ip获得ip对象
	InetAddress ip2=InetAddress.getByName("123.56.138.86");
//	注意如果DNS不允许进行IP与域名映射时，将不会返回域名
	System.out.println(ip2.getHostName());
	System.out.println(ip2.getHostAddress());//该域名ip地址
}
}
