package UDPTest;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

public class UDPClient {
public static void main(String[] args) throws IOException {
	System.out.println("��ʼ����");
//	1.�����˿����ڰ����ݴ�Ӧ�ò㴫�������
	DatagramSocket ds=new DatagramSocket(8888);
//	2.ѡ��Ҫ���͵���Դ��ת���ֽ�����
//	String str="������";
//	byte[] bytes=str.getBytes();
//	Ҫ����ֽ����飬�ܶ������Ҫ�������������ֽ���,���������������д���ֽ�������������ֽ��������toByteArray����
	ByteArrayOutputStream baos=new ByteArrayOutputStream();
	DataOutputStream dos=new DataOutputStream(baos);
	dos.writeBoolean(true);
	dos.writeDouble(4.0);
	dos.writeInt(5);
	byte[] bytes=baos.toByteArray();
//	3.�����ݲ��֣��ֽ����飩�Ž�packet
//	Ҫע��һ���ǣ�Ҫ���͵Ķ˿ڲ��Ƿ���ʱ��ָ�������ǷŽ�packetʱ���Ѿ�ָ������new InetSocketAddress����
	DatagramPacket dp=new DatagramPacket(bytes, 0,bytes.length,new InetSocketAddress("localhost",9999) {
	});
//	4.���ͱ���
	ds.send(dp);
//	5.�رն˿�
	ds.close();
}
}
