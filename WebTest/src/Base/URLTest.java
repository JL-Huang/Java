package Base;

import java.net.MalformedURLException;
import java.net.URL;

//���췽��public URL(String protocol, String host, int port, String file)
//URL:Э��+IP������+�˿ڣ�Ĭ��80��+������Դ
public class URLTest {
public static void main(String[] args) throws MalformedURLException {
	URL url1=new URL("https://www.bilibili.com/video/BV1ct411n7oG?p=238");
	System.out.println("Э��->"+url1.getProtocol());
	System.out.println("����/IP->"+url1.getHost());
	System.out.println("������Դ �ļ���->"+url1.getFile());//��������
	System.out.println("������Դ �ļ���->"+url1.getPath());//URI���ݣ�����������ê��
	System.out.println(url1.getPort());
	System.out.println("����"+url1.getQuery());
	System.out.println("ê��"+url1.getRef());
}
}
