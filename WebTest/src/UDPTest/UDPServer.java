package UDPTest;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
//UDP����ҪIO��
//UDP�Ľ���������ʽ���գ���receiveִ�к��һֱ�ȴ�����
public class UDPServer {
public static void main(String[] args) throws IOException {
	System.out.println("��ʼ����");
//	1.����˿����ڴ�������������,ע��˿���int����
	DatagramSocket ds=new DatagramSocket(9999);
//	2.����һ���ֽ����飬�������ݲ���
	byte[] bytes=new byte[1024];
//	3.����packet���ڽ��ձ���
	DatagramPacket dp=new DatagramPacket(bytes, 0, bytes.length);
//	4.���ձ���
	ds.receive(dp);
//	4.��packet,������ݲ���,��ʵ���ݾ��ǸղŴ������ֽ�����
//	���ǽ����½�һ���ֽ�������dp.getData()����Ϊ�ղŴ��������鳤���ǹ̶��ģ������
//	byte[] b=dp.getData();
//	byte[] b=dp.getData();
	DataInputStream dis=new DataInputStream(new ByteArrayInputStream(bytes));
//	5.�����ݲ��ֽ��д����ر��ǻ�ԭ
//	System.out.println(new String(bytes, 0, b.length));
	System.out.println(dis.readBoolean());
	System.out.println(dis.readDouble());
	System.out.println(dis.readInt());
//	6.�رն˿�
	ds.close();
}

}
