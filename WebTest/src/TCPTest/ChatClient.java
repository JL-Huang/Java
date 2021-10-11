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
//	这可能是socket的性质，其getinputStream读的是服务器写的内容不是本地写的内容
//	InputStream is=s.getInputStream();
//	DataInputStream dis=new DataInputStream(is);
//	boolean isrunning =true;
//	while(isrunning) {
//		String data=br.readLine();
//		dos.writeUTF(data);
//		dos.flush();
	System.out.println("请输入用户名：");
	String name=new BufferedReader(new InputStreamReader(System.in)).readLine();
	System.out.println("可以开始聊天了");
	new Thread(new Send(s,name)).start();;
		
//	犯了严重的错误！不能在这里关闭输出流，否则在服务器不能对Socket进行写操作
//	dos.close();不能
//		System.out.println(dis.readUTF());
//		也不能在这里关闭socket与流。因为服务端还要继续对流进行操作
//		dis.close();不能
//		dos.close();不能
//		s.close();不能
//	}
//	dis.close();
//	dos.close();
	new Thread(new Receive(s)).start();;
//	s.close();
}
}
