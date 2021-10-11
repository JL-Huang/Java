package TCPTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//Socket的getInputStream是对Socket进行读操作，DataInputStream连接到socket的输入流，再进行读操作
//Socket的getInputStream是对Socket进行写操作，DataInputStream连接到socket的输入流，再进行写操作
public class TCPServer {
	static String name;
	static String password;
	public static void main(String[] args) {
		try {
//		1.指定端口，用ServerSocket创建服务器套接字
			ServerSocket ss=new ServerSocket(9999);
//		2.阻塞式等待连接accept(),返回一个客户端套接字对象Socket
			Socket s=ss.accept();
//		3.输入输出流操作
			DataInputStream dis=new DataInputStream(s.getInputStream());
			String data=dis.readUTF();
//			以某个符号把字符串分割为字符串数组，学到了
			String[] sondata=data.split("&");
			for(String s1:sondata) {
				String[] grandsondata=s1.split("=");
				if(grandsondata[0].equals("账号")) {
					System.out.println("输入账号为"+grandsondata[1]);
					name=grandsondata[1];
				}else {
					System.out.println("输入密码为"+grandsondata[1]);
					password=grandsondata[1];
				}
			}
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			if(name.equals("123456")&& password.equals("abc")) {
				dos.writeUTF("登录成功");				
			}else {
				dos.writeUTF("登录失败");
			}
//		4.释放资源
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
