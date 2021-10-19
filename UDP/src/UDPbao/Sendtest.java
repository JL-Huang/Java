package UDPbao;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Sendtest {
	public static void main(String[] args) throws Exception {
		System.out.println("发送");
		//第一步，新建一个Socket，指定本地一个端口作为发送端口
		DatagramSocket ds=new DatagramSocket(9999);
		//第二步，准备要发送的数据
		String fasong="账号1234567";
		//第三步，创建一个容器，装好数据。与接收端不同的是，发送端的容器是已经有内容的
		byte[] container=fasong.getBytes();
		//第四步，将容器放进包裹,与接收端不同的是，发送端需要在包裹上指定要发送的地址和端口
		//目的地是通过将地址和端口作为InetSocketAddress方法的两个参数然后构造对象实现，不是简单的int类型
		DatagramPacket dp=new DatagramPacket(container,container.length,new InetSocketAddress("localhost",8888));
		//第五步，DataSocket发送包裹
		ds.send(dp);
		//第六步，释放DataSocket中的资源
		ds.close();
	}

}
