package Base;
//InetAdress�����һ��IP��ַ����װ�˺ܶ���Ϣ
//�����û�й��췽����ֻ�о�̬��������
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetTest {
public static void main(String[] args) throws UnknownHostException {
//	��̬���������ر�����������ַ
	InetAddress ip=InetAddress.getLocalHost();
	System.out.println(ip);
	System.out.println(ip.getHostAddress());
	System.out.println(ip.hashCode());
//	�����������ip����
	InetAddress ip1=InetAddress.getByName("www.baidu.com");
	System.out.println(ip1.getHostName());//����
	System.out.println(ip1.getHostAddress());//������ip��ַ
//	����ip���ip����
	InetAddress ip2=InetAddress.getByName("123.56.138.86");
//	ע�����DNS���������IP������ӳ��ʱ�������᷵������
	System.out.println(ip2.getHostName());
	System.out.println(ip2.getHostAddress());//������ip��ַ
}
}
