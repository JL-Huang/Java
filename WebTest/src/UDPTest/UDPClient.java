package UDPTest;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

public class UDPClient {
public static void main(String[] args) throws IOException {
	System.out.println("开始发送");
//	1.创建端口用于把数据从应用层传往运输层
	DatagramSocket ds=new DatagramSocket(8888);
//	2.选择要发送的资源，转成字节数组
//	String str="哈哈哈";
//	byte[] bytes=str.getBytes();
//	要变成字节数组，很多情况下要依靠数据流与字节流,数据输出流把数据写入字节输出流，再用字节输出流的toByteArray方法
	ByteArrayOutputStream baos=new ByteArrayOutputStream();
	DataOutputStream dos=new DataOutputStream(baos);
	dos.writeBoolean(true);
	dos.writeDouble(4.0);
	dos.writeInt(5);
	byte[] bytes=baos.toByteArray();
//	3.把数据部分（字节数组）放进packet
//	要注意一点是，要发送的端口不是发送时才指定，而是放进packet时就已经指定，用new InetSocketAddress方法
	DatagramPacket dp=new DatagramPacket(bytes, 0,bytes.length,new InetSocketAddress("localhost",9999) {
	});
//	4.发送报文
	ds.send(dp);
//	5.关闭端口
	ds.close();
}
}
