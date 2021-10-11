package Base;

import java.net.MalformedURLException;
import java.net.URL;

//构造方法public URL(String protocol, String host, int port, String file)
//URL:协议+IP或域名+端口（默认80）+请求资源
public class URLTest {
public static void main(String[] args) throws MalformedURLException {
	URL url1=new URL("https://www.bilibili.com/video/BV1ct411n7oG?p=238");
	System.out.println("协议->"+url1.getProtocol());
	System.out.println("域名/IP->"+url1.getHost());
	System.out.println("请求资源 文件名->"+url1.getFile());//具体内容
	System.out.println("请求资源 文件名->"+url1.getPath());//URI内容，不包括参数锚点
	System.out.println(url1.getPort());
	System.out.println("参数"+url1.getQuery());
	System.out.println("锚点"+url1.getRef());
}
}
