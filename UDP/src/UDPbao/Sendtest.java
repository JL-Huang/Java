package UDPbao;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Sendtest {
	public static void main(String[] args) throws Exception {
		System.out.println("����");
		//��һ�����½�һ��Socket��ָ������һ���˿���Ϊ���Ͷ˿�
		DatagramSocket ds=new DatagramSocket(9999);
		//�ڶ�����׼��Ҫ���͵�����
		String fasong="�˺�1234567";
		//������������һ��������װ�����ݡ�����ն˲�ͬ���ǣ����Ͷ˵��������Ѿ������ݵ�
		byte[] container=fasong.getBytes();
		//���Ĳ����������Ž�����,����ն˲�ͬ���ǣ����Ͷ���Ҫ�ڰ�����ָ��Ҫ���͵ĵ�ַ�Ͷ˿�
		//Ŀ�ĵ���ͨ������ַ�Ͷ˿���ΪInetSocketAddress��������������Ȼ�������ʵ�֣����Ǽ򵥵�int����
		DatagramPacket dp=new DatagramPacket(container,container.length,new InetSocketAddress("localhost",8888));
		//���岽��DataSocket���Ͱ���
		ds.send(dp);
		//���������ͷ�DataSocket�е���Դ
		ds.close();
	}

}
