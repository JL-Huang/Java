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
//		1.指定端口，用ServerSocket创建服务器套接字
			ServerSocket ss=new ServerSocket(9999);
//		2.阻塞式等待连接accept(),返回一个客户端套接字对象Socket
			Socket s=ss.accept();
//		3.输入输出流操作
			OutputStream os=new BufferedOutputStream(new FileOutputStream(new File("jjj.bmp")));
			InputStream is=new BufferedInputStream(s.getInputStream());
			byte[] bytes=new byte[1024];
			int len=-1;
			while((len=is.read(bytes))!=-1) {
				os.write(bytes);
			}
//		4.释放资源
			is.close();
			os.close();
//			注意这里服务器关不关都没关系
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

