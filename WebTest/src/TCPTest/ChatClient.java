package TCPTest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {

public static void main(String[] args) throws UnknownHostException, IOException {
	Socket s=new Socket("localhost",8848);
//	OutputStream os=s.getOutputStream();
//	DataOutputStream dos=new DataOutputStream(os);
//	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//	�������socket�����ʣ���getinputStream�����Ƿ�����д�����ݲ��Ǳ���д������
//	InputStream is=s.getInputStream();
//	DataInputStream dis=new DataInputStream(is);
//	boolean isrunning =true;
//	while(isrunning) {
//		String data=br.readLine();
//		dos.writeUTF(data);
//		dos.flush();
	System.out.println("�������û�����");
	String name=new BufferedReader(new InputStreamReader(System.in)).readLine();
	System.out.println("���Կ�ʼ������");
	new Thread(new Send(s,name)).start();;
		
//	�������صĴ��󣡲���������ر�������������ڷ��������ܶ�Socket����д����
//	dos.close();����
//		System.out.println(dis.readUTF());
//		Ҳ����������ر�socket��������Ϊ����˻�Ҫ�����������в���
//		dis.close();����
//		dos.close();����
//		s.close();����
//	}
//	dis.close();
//	dos.close();
	new Thread(new Receive(s)).start();;
//	s.close();
}
}
