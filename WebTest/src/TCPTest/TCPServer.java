package TCPTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//Socket��getInputStream�Ƕ�Socket���ж�������DataInputStream���ӵ�socket�����������ٽ��ж�����
//Socket��getInputStream�Ƕ�Socket����д������DataInputStream���ӵ�socket�����������ٽ���д����
public class TCPServer {
	static String name;
	static String password;
	public static void main(String[] args) {
		try {
//		1.ָ���˿ڣ���ServerSocket�����������׽���
			ServerSocket ss=new ServerSocket(9999);
//		2.����ʽ�ȴ�����accept(),����һ���ͻ����׽��ֶ���Socket
			Socket s=ss.accept();
//		3.�������������
			DataInputStream dis=new DataInputStream(s.getInputStream());
			String data=dis.readUTF();
//			��ĳ�����Ű��ַ����ָ�Ϊ�ַ������飬ѧ����
			String[] sondata=data.split("&");
			for(String s1:sondata) {
				String[] grandsondata=s1.split("=");
				if(grandsondata[0].equals("�˺�")) {
					System.out.println("�����˺�Ϊ"+grandsondata[1]);
					name=grandsondata[1];
				}else {
					System.out.println("��������Ϊ"+grandsondata[1]);
					password=grandsondata[1];
				}
			}
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			if(name.equals("123456")&& password.equals("abc")) {
				dos.writeUTF("��¼�ɹ�");				
			}else {
				dos.writeUTF("��¼ʧ��");
			}
//		4.�ͷ���Դ
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
