package UDPbao;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receivetest {
	public static void main(String[] arg) throws Exception {
		System.out.println("����");
		//��һ�����½�һ��DatagramSocket��ָ������������һ���˿���Ϊ���ն˶˿�
		DatagramSocket ds=new DatagramSocket(8888); 
		//�ڶ������½�һ��������������Ž��յ�����,ע�⹹��ʱָ��������UDP�����64K
		byte[] container=new byte[1024*32];
		//���������½�һ����������DatagramPacket�������������������������ָֻ��������������һ����������һ���ǳ���
		//UDP�ļ�֮�����ڣ����ն˲���Ҫָ�����Ͷ˵ĵ�ַ���˿�
		DatagramPacket dp=new DatagramPacket(container,container.length);
		//���Ĳ���DataSocket����ʽ���հ���
		ds.receive(dp);
		//���岽����getData����򿪰���������һ������װ����
		byte[] shuju=dp.getData();
		//���������԰��������Ϣ���д���
		System.out.println(new String(shuju));
		//���߲����ͷ�DataSocket�е���Դ
		ds.close();
	}

}
