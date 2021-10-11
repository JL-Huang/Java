package UDPTest;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
//UDP不需要IO流
//UDP的接收是阻塞式接收，即receive执行后会一直等待数据
public class UDPServer {
public static void main(String[] args) throws IOException {
	System.out.println("开始接收");
//	1.常简端口用于从运输层接收数据,注意端口是int类型
	DatagramSocket ds=new DatagramSocket(9999);
//	2.创建一个字节数组，就是数据部分
	byte[] bytes=new byte[1024];
//	3.创建packet用于接收报文
	DatagramPacket dp=new DatagramPacket(bytes, 0, bytes.length);
//	4.接收报文
	ds.receive(dp);
//	4.拆开packet,获得数据部分,其实内容就是刚才创建的字节数组
//	但是建议新建一个字节数组再dp.getData()，因为刚才创建的数组长度是固定的，不灵活
//	byte[] b=dp.getData();
//	byte[] b=dp.getData();
	DataInputStream dis=new DataInputStream(new ByteArrayInputStream(bytes));
//	5.对数据部分进行处理，特别是还原
//	System.out.println(new String(bytes, 0, b.length));
	System.out.println(dis.readBoolean());
	System.out.println(dis.readDouble());
	System.out.println(dis.readInt());
//	6.关闭端口
	ds.close();
}

}
