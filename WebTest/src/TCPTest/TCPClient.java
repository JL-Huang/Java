package TCPTest;
import java.io.BufferedReader;
import java.io.DataInputStream;
//客户端与UDP不同的是，TCP不需要指定当前端口，也不需要打包成报文，甚至不需要声明发送，只需要把数据打进输出流
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
public static void main(String[] args) {
	try {
//		1.使用Socket创建客户端套接字，指定目的地址和服务器端口
		Socket socket=new Socket("localhost", 9998);
//		2.输入输出流操作,使用DataOutputStream获得要操作的对象
//		这里稍作说明，Socket定义是IP+port
//		而Socket类下面有InputStream与OutputStream两个属性
//		当要将Socket的数据进行操作，用的是写，从程序写入socket，可以用其输出流的write
		OutputStream os=socket.getOutputStream();
		DataOutputStream dos=new DataOutputStream(os);
//		要注意的是，获得键盘输入内容，需要先将其转化为字符流
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入账号");
		String name=br.readLine();
		System.out.print("请输入密码");
		String password=br.readLine();
//		将一个字符串写入，用UTF-8编码
		dos.writeUTF("账号="+name+"&"+"密码="+password);
		dos.flush();
//		这里的getInputStream比较难理解，用socket的getInputStream对socket进行了写操作
//		但是在通信过程中，服务器又对socket进行了写操作，所以这里读的是服务器传回来的数据
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		System.out.println(dis.readUTF());
//		3.关闭客户端
		dos.close();
		socket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
