package TCPTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileServer {
	public static void main(String[] args) {
		try {
//		1.ָ���˿ڣ���ServerSocket�����������׽���
			ServerSocket ss=new ServerSocket(9999);
//		2.����ʽ�ȴ�����accept(),����һ���ͻ����׽��ֶ���Socket
			Socket s=ss.accept();
//		3.�������������
			OutputStream os=new BufferedOutputStream(new FileOutputStream(new File("jjj.bmp")));
			InputStream is=new BufferedInputStream(s.getInputStream());
			byte[] bytes=new byte[1024];
			int len=-1;
			while((len=is.read(bytes))!=-1) {
				os.write(bytes);
			}
//		4.�ͷ���Դ
			is.close();
			os.close();
//			ע������������ز��ض�û��ϵ
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

