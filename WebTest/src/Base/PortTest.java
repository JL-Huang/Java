package Base;
//Socket�׽��֣��׽��ֵ�ַָIP��ַ�Ӷ˿ںŻ�������ַ�Ӷ˿ں�
//�˿��Ǵ����ĸ��UDP��TCPͬһЭ���µĶ˿ڲ����ظ�
//�����ͬ��û�й��췽��
import java.net.InetSocketAddress;

public class PortTest {
public static void main(String[] args) {
	 InetSocketAddress isa1=new InetSocketAddress("127.0.0.1",8888);
//	 ��ȡ��ǰSocket��ַ�˿ں�
	 System.out.println(isa1.getPort());
	 InetSocketAddress isa2=new InetSocketAddress("localhost",9999);
	 
}
}
