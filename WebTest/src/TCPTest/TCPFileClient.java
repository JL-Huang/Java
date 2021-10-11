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
//				1.使用Socket创建客户端套接字，指定目的地址和服务器端口
				Socket socket=new Socket("localhost", 9999);
//				2.输入输出流操作,使用DataOutputStream获得要操作的对象
				InputStream is=new BufferedInputStream( new FileInputStream(new File("hhh.bmp")));
				OutputStream os=socket.getOutputStream();
				byte[] bytes=new byte[1024];
				int len=-1;
				while((len=is.read(bytes))!=-1) {
					os.write(bytes);
				}
				os.flush();
//				3.关闭客户端
				os.close();
				is.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
