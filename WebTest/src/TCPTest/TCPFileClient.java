package TCPTest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPFileClient {


		public static void main(String[] args) {
			try {
//				1.ʹ��Socket�����ͻ����׽��֣�ָ��Ŀ�ĵ�ַ�ͷ������˿�
				Socket socket=new Socket("localhost", 9999);
//				2.�������������,ʹ��DataOutputStream���Ҫ�����Ķ���
				InputStream is=new BufferedInputStream( new FileInputStream(new File("hhh.bmp")));
				OutputStream os=socket.getOutputStream();
				byte[] bytes=new byte[1024];
				int len=-1;
				while((len=is.read(bytes))!=-1) {
					os.write(bytes);
				}
				os.flush();
//				3.�رտͻ���
				os.close();
				is.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
